package com.pfa.annotationmanager.controller;

import com.pfa.annotationmanager.model.*;
import com.pfa.annotationmanager.repository.ExpertCandidateRepository;
import com.pfa.annotationmanager.repository.ExpertRepository;
import com.pfa.annotationmanager.repository.TextRepository;
import com.pfa.annotationmanager.service.ExpertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expert")
public class ExpertController {
    private final ExpertRepository expertRepository;


    private final ExpertCandidateRepository expertCandidateRepository;

    @Autowired
    private TextRepository textRepository;

    @Autowired
    private ExpertService expertService;
    public ExpertController(ExpertRepository expertRepository,ExpertCandidateRepository expertCandidateRepository) {
        this.expertRepository = expertRepository;
        this.expertCandidateRepository = expertCandidateRepository;
    }

    @GetMapping("/texts")
    public List<Text> getalltexts(Authentication authentication){
        //get the expert
        String username = authentication.getName();
        Expert expert =  expertRepository.findByEmail(username).orElse(null);

        return expertService.getAllTextsForExpert(expert);
    }

    @PostMapping("/set-candidate/{id}")
    public ResponseEntity<Void> setCandidate(Authentication authentication,@PathVariable Long id){
        //get the expert
        String username = authentication.getName();
        Expert expert =  expertRepository.findByEmail(username).orElse(null);

        //get text and create a new candidate
        Boolean t = expertService.setCandidate(expert,id);
        return t? ResponseEntity.noContent().build():ResponseEntity.badRequest().build();
    }
    @GetMapping("/candidates")
    public List<ExpertCandidate> getAllCandidates(Authentication authentication) {
        String username = authentication.getName();
        Expert expert =  expertRepository.findByEmail(username).orElse(null);

        // Process the list of ExpertCandidates as needed
        return expertService.getAllCandidates(expert);
    }

    @GetMapping("/candidates/{id}")
    public ResponseEntity<ExpertCandidate> getCandidatebyid(@PathVariable Long id) {
        Optional<ExpertCandidate> expertOptional = expertCandidateRepository.findById(id);
        return expertOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
//    @GetMapping("/candidates/{id}/annotations")
//    public ResponseEntity<List<AnnotationCandidate>> getCandidateAnnotationsbyid(@PathVariable Long id) {
//        Optional<List<AnnotationCandidate>> annotationCandidates = annotationCandidateRepository.findAllByExpertCandidateId(id);
//        return annotationCandidates.map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }


    @PostMapping("/cadidates/{id}/annotate")
    public ResponseEntity<Expert> createAnnotations(Authentication authentication,@PathVariable Long id,
                                                    @RequestBody List<AnnotationCandidate> annotations) {
        //get the expert
        String username = authentication.getName();
        Expert expert =  expertRepository.findByEmail(username).orElse(null);

        expertService.createAnnotations(expert,id, annotations);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/cadidates/{id}/annotate")
    public ResponseEntity<Expert> updateAnnotations(Authentication authentication,@PathVariable Long id,
                                                    @RequestBody List<AnnotationCandidate> annotations) {
        //get the expert
        String username = authentication.getName();
        Expert expert =  expertRepository.findByEmail(username).orElse(null);

        expertService.updateAnnotations(expert,id, annotations);

        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<Expert> updateExpert(@PathVariable Long id, @RequestBody Expert expert) {
        if (!expertRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        expert.setId(id);
        Expert updatedExpert = expertRepository.save(expert);
        return ResponseEntity.ok(updatedExpert);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpert(@PathVariable Long id) {
        if (!expertRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        expertRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
