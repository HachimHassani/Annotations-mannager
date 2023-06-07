package com.pfa.annotationmanager.service;

import com.pfa.annotationmanager.model.*;
import com.pfa.annotationmanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpertService {
    public static List<AnnotationCandidate> annotationCandidates;
    private final ExpertRepository expertRepository;

    @Autowired
    private  ExpertCandidateRepository expertCandidateRepository;
    @Autowired
    private AnnotationRepository annotationRepository;

    @Autowired
    private ScientificClassRepository scientificClassRepository;
    @Autowired
    private TextRepository textRepository;

    @Autowired
    private  AnnotationCandidateRepository annotationCandidateRepository;

    @Autowired
    private ElementIdChoicesRepository elementIdChoicesRepository;

    @Autowired
    private ElementIdRepository elementIdRepository;

    @Autowired
    private ElementIdCandidateRepository elementIdCandidateRepository;

    @Autowired
    private IdentificationService identificationService;

    @Autowired
    public ExpertService(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    public Boolean setCandidate(Expert expert, Long id){
        //get text and create a new candidate
        Text text = textRepository.findById(id).orElse(null);
        if (text==null||(text.getState()!=null&&text.getState()!=TextState.INIT)){return false;}
        if (expertCandidateRepository.findByExpertAndTextId(expert,id).isPresent()){return false;}
        ExpertCandidate candidate = new ExpertCandidate();
        candidate.setText(text);
        candidate.setExpert(expert);
        candidate.setAnnotationstate(TextState.INIT);
        expertCandidateRepository.save(candidate);
        return  true;

    }
    public static <T> LinkedHashMap<T, Integer> sortMapByValue(Map<T, Integer> frequencyMap) {
        return frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
    public static <T> Map<T, Integer> calculateFrequency(List<T> elements) {
        Map<T, Integer> frequencyMap = new HashMap<>();

        for (T element : elements) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }
    public List<ExpertCandidate> getAllCandidates(Expert expert){
        return expertCandidateRepository.findAllByExpert(expert).orElse(null);
    }

    public List<Text> getAllTextsForExpert(Expert expert){
        List<Text> res = textRepository.findAll();
        return res;
    }

    public  Optional<List<AnnotationCandidate>> getAnnotationCandidates(Long id){
        return annotationCandidateRepository.findAllByExpertCandidateId(id);

    }

    public void review(Long id) {
        Text text = textRepository.findById(id).orElse(null);
        if (text != null) {
            List<ExpertCandidate> all = text.getCandidates();
            List<AnnotationCandidate> global = new ArrayList<>();
            for (ExpertCandidate expertCandidate : all) {


                for (AnnotationCandidate annotationCandidate : expertCandidate.getAnnotationCandidates()) {
                    // Check specific conditions to determine if the annotation is missing
                    if (global.stream().noneMatch(element -> Objects.equals(element.getStart(), annotationCandidate.getStart()) && Objects.equals(element.getEnd(), annotationCandidate.getEnd()))) {
                        global.add(annotationCandidate);
                    }
                }


            }
            annotationCandidates = global;
        }
    }

    public  List<AnnotationCandidate> getMissingCandidates(Long id) {
        ExpertCandidate cand = expertCandidateRepository.findById(id).orElse(null);
        List<AnnotationCandidate> candidates = new ArrayList<>(List.copyOf(annotationCandidates));

        if (cand != null) {
            List<AnnotationCandidate> existing = cand.getAnnotationCandidates();
            candidates.removeIf(ann -> existing.stream().noneMatch(element -> Objects.equals(element.getStart(), ann.getStart()) && Objects.equals(element.getEnd(), ann.getEnd())));
        }
        return candidates;
    }

    public void crossValidation(Long textId){
        Text text = textRepository.findById(textId).orElse(null);
        List<Integer> froms = new ArrayList<>();
        List<CrossValidationAnnotations> cross = new ArrayList<>();
        assert text != null;
        List<ExpertCandidate> candidates = text.getCandidates();
        int count =  candidates.size();
            for (ExpertCandidate expertCandidate : candidates) {

                for (AnnotationCandidate annotationCandidate : expertCandidate.getAnnotationCandidates()) {
                    Optional<CrossValidationAnnotations> test = cross.stream().filter(element -> ((element.getFrom() <= annotationCandidate.getStart() && element.getTo()>annotationCandidate.getEnd())||
                            (annotationCandidate.getEnd()>= element.getFrom() && element.getFrom() >= annotationCandidate.getStart()))).findFirst();
                    // Check specific conditions to determine if the annotation is missing
                    if (test.isPresent()) {
                        test.get().addScientificClass(annotationCandidate.getScientifcClass());
                    }else{
                        CrossValidationAnnotations newAnnotation = new CrossValidationAnnotations(annotationCandidate.getStart(),annotationCandidate.getEnd(), Collections.singletonList(annotationCandidate.getScientifcClass()));
                        cross.add(newAnnotation);
                    }
                }


            }
            for (CrossValidationAnnotations item:cross){
                Map<ScientifcClass, Integer> t = calculateFrequency(item.getScientifcClass());
                LinkedHashMap<ScientifcClass, Integer> sortedMap = sortMapByValue(t);
                int i = sortedMap.size();
                if (i>= count/2){
                    ScientifcClass key = sortedMap.keySet().stream().findFirst().orElse(null);
                    Annotation annotation = new Annotation();
                    annotation.setFrom(item.getFrom());
                    annotation.setTo(item.getTo());
                    annotation.setScientifcClass(key);
                    annotation.setText(text);
                    annotationRepository.save(annotation);
                }
            }

            return;
    }

    public boolean setIds(){
        if (elementIdRepository.count() <= 3){
            return false;
        }else {
            List<Annotation> annotations = annotationRepository.findAll();
            List<ElementIdChoices> choices = new ArrayList<>();
            for (Annotation annotation:annotations){
                ElementIdChoices elementIdChoices = new ElementIdChoices();
                elementIdChoices.setAnnotation(annotation);
               choices.add(elementIdChoices);
            }
            elementIdChoicesRepository.saveAll(choices);
            identificationService.pickRandomElements();
            return true;
        }
    }

    public List<ScientifcClass> getallClasses(){
        return scientificClassRepository.findAll();
    }

    public void createAnnotations(Expert expert, Long id, List<Map<String,Object>> request){
        //asssumes that the id is for the expertcandidate
        ExpertCandidate cand=expertCandidateRepository.findById(id).orElse(null);
        //checks the state
        List<AnnotationCandidate> annotations = new ArrayList<>();
        if((cand!=null&&cand.getAnnotationstate()!=TextState.ANNOTATED)) {
           for (Map<String,Object> annotation: request){
               AnnotationCandidate annot = new AnnotationCandidate();
               annot.setExpertCandidate(cand);
               annot.setScientifcClass(scientificClassRepository.findByName((String) annotation.get("tag")).orElse(null));
               annot.setStart((int) annotation.get("start"));
               annot.setEnd((int) annotation.get("end"));
               annotations.add(annot);
           }

            annotationCandidateRepository.saveAll(annotations);
            cand.setAnnotationCandidates(annotations);
            cand.setAnnotationstate(TextState.REVIEW);
            expertCandidateRepository.save(cand);
        }
    }
    public void updateAnnotations(Expert expert,Long id, List<AnnotationCandidate> annotations){
        //asssumes that the id is for the expertcandidate
        ExpertCandidate cand=expertCandidateRepository.findById(id).orElse(null);
        //checks the state
        if((cand!=null)&&(cand.getAnnotationstate()==TextState.REVIEW||cand.getAnnotationstate()==TextState.ANNOTATED)) {
            cand.setAnnotationCandidates(annotations);
            cand.setAnnotationstate(TextState.ANNOTATED);
        }
    }
    public List<Expert> getAllExperts() {
        return expertRepository.findAll();
    }

    public Optional<Expert> getExpertById(Long id) {
        return expertRepository.findById(id);
    }

    public Expert createExpert(Expert expert) {
        return expertRepository.save(expert);
    }

    public Expert updateExpert(Long id, Expert updatedExpert) {
        Optional<Expert> optionalExpert = expertRepository.findById(id);
        if (optionalExpert.isPresent()) {
            Expert existingExpert = optionalExpert.get();
            existingExpert.setFirstname(updatedExpert.getFirstname());
            existingExpert.setLastname(updatedExpert.getLastname());
            existingExpert.setEmail(updatedExpert.getEmail());
            existingExpert.setPassword(updatedExpert.getPassword());
            existingExpert.setRole(updatedExpert.getRole());
            existingExpert.setRating(updatedExpert.getRating());
            return expertRepository.save(existingExpert);
        }
        return null;
    }

    public void deleteExpert(Long id) {
        expertRepository.deleteById(id);
    }

    public  void confirmAnnotations(Expert expert,Long id) {
        //asssumes that the id is for the expertcandidate
        ExpertCandidate cand=expertCandidateRepository.findById(id).orElse(null);

        assert cand != null;
        cand.setAnnotationstate(TextState.ANNOTATED);
        List<ExpertCandidate> cands = cand.getText().getCandidates();
        for (ExpertCandidate candidate:cands){
            if (candidate.getAnnotationstate()!=null&&candidate.getAnnotationstate()!=TextState.REVIEW)
            {
                return;
            }
        }
        crossValidation(id);
    }
}
