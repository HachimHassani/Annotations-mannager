package com.pfa.annotationmanager.service;

import com.pfa.annotationmanager.model.*;
import com.pfa.annotationmanager.repository.ExpertCandidateRepository;
import com.pfa.annotationmanager.repository.ExpertRepository;
import com.pfa.annotationmanager.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExpertService {

    private final ExpertRepository expertRepository;

    @Autowired
    private  ExpertCandidateRepository expertCandidateRepository;

    @Autowired
    private TextRepository textRepository;

    @Autowired
    public ExpertService(ExpertRepository expertRepository) {
        this.expertRepository = expertRepository;
    }

    public Boolean setCandidate(Expert expert, Long id){
        //get text and create a new candidate
        Text text = textRepository.findById(id).orElse(null);
        if (text==null){return false;}
        if (expertCandidateRepository.findByExpertAndText(expert.getId(),id).isPresent()){return false;}
        ExpertCandidate candidate = new ExpertCandidate();
        candidate.setText(text);
        candidate.setExpert(expert);
        candidate.setAnnotationstate(TextState.INIT);
        expertCandidateRepository.save(candidate);
        return  true;

    }
    public List<ExpertCandidate> getAllCandidates(Expert expert){
        return expertCandidateRepository.findAllByExpert(expert).orElse(null);
    }

    public List<Text> getAllTextsForExpert(Expert expert){
        List<Text> res = textRepository.findAll();
        return res;
    }

//    public void review(Long id) {
//        Text text = textRepository.findById(id).orElse(null);
//        if (text != null) {
//            List<ExpertCandidate> all = text.getCandidates();
//            List<AnnotationCandidate> global = new ArrayList<>();
//            for (ExpertCandidate expertCandidate : all) {
//
//
//                for (AnnotationCandidate annotationCandidate : expertCandidate.getAnnotationCandidates()) {
//                    // Check specific conditions to determine if the annotation is missing
//                    if (global.stream().noneMatch(element -> Objects.equals(element.getFrom(), annotationCandidate.getFrom()) && Objects.equals(element.getTo(), annotationCandidate.getTo()))) {
//                        global.add(annotationCandidate);
//                    }
//                }
//
//                // Perform actions with missing annotations
//                // For example, you can print the missing annotations
//                System.out.println("Missing annotations for ExpertCandidate: " + expertCandidate.getId());
//                for (AnnotationCandidate missingAnnotation : missingAnnotations) {
//                    System.out.println(missingAnnotation.getId());
//                }
//            }
//        }
//    }
    public void createAnnotations(Expert expert,Long id, List<AnnotationCandidate> annotations){
        //asssumes that the id is for the expertcandidate
        ExpertCandidate cand=expertCandidateRepository.findById(id).orElse(null);
        //checks the state
        if((cand!=null)&&(cand.getAnnotationstate()==TextState.INIT)) {
            cand.setAnnotationCandidates(annotations);
            cand.setAnnotationstate(TextState.REVIEW);
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
}
