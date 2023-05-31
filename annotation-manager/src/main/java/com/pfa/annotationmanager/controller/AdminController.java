package com.pfa.annotationmanager.controller;

import com.pfa.annotationmanager.model.Expert;
import com.pfa.annotationmanager.model.Text;
import com.pfa.annotationmanager.repository.ExpertRepository;
import com.pfa.annotationmanager.repository.TextRepository;
import com.platform.parkingsystem.api.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {
    private final TextRepository textRepository;
    private final ExpertRepository expertRepository;

    @Autowired
    public AdminController(TextRepository textRepository, ExpertRepository expertRepository) {
        this.textRepository = textRepository;
        this.expertRepository = expertRepository;
    }

    // Endpoint to add a new expert
    @PostMapping("/experts")
    public ResponseEntity<Expert> addExpert(@RequestBody Expert expert) {
        Expert savedExpert = expertRepository.save(expert);
        return new ResponseEntity<>(savedExpert, HttpStatus.CREATED);
    }

    // Endpoint to remove an expert by ID
    @DeleteMapping("/experts/{id}")
    public ResponseEntity<Void> removeExpert(@PathVariable Long id) {
        expertRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Endpoint to add a new text
    @PostMapping("/texts")
    public ResponseEntity<Text> addText(@RequestBody Text text) {
        Text savedText = textRepository.save(text);
        return new ResponseEntity<>(savedText, HttpStatus.CREATED);
    }

    // Endpoint to start annotations for a text by ID
    @PostMapping("/texts/{id}/annotations")
    public ResponseEntity<String> startAnnotations(@PathVariable Long id) {
        // Logic to start annotations for the given text
        return new ResponseEntity<>("Annotations started for text with ID: " + id, HttpStatus.OK);
    }

    // Endpoint to edit a text by ID
    @PutMapping("/texts/{id}")
    public ResponseEntity<Text> editText(@PathVariable Long id, @RequestBody Text text) {
        Text existingText = textRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Text not found with ID: " + id));

        existingText.setContent(text.getContent());
        Text updatedText = textRepository.save(existingText);

        return new ResponseEntity<>(updatedText, HttpStatus.OK);
    }

    // Endpoint to delete a text by ID
    @DeleteMapping("/texts/{id}")
    public ResponseEntity<Void> deleteText(@PathVariable Long id) {
        textRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}