package com.pfa.annotationmanager.controller;


import com.pfa.annotationmanager.model.ScientifcClass;
import com.pfa.annotationmanager.repository.ScientificClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/ScientificClass")
public class ScientificController {

    @Autowired
    private  ScientificClassRepository scientifcClassRepository;


    @GetMapping
    public ResponseEntity<List<ScientifcClass>> getAllScientifcClasses() {
        List<ScientifcClass> scientificClasses = scientifcClassRepository.findAll();
        return new ResponseEntity<>(scientificClasses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScientifcClass> getScientifcClassById(@PathVariable("id") Long id) {
        Optional<ScientifcClass> optionalScientifcClass = scientifcClassRepository.findById(id);
        return optionalScientifcClass.map(scientificClass -> new ResponseEntity<>(scientificClass, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ScientifcClass> createScientifcClass(@RequestBody ScientifcClass scientifcClass) {
        ScientifcClass createdScientifcClass = scientifcClassRepository.save(scientifcClass);
        return new ResponseEntity<>(createdScientifcClass, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScientifcClass> updateScientifcClass(
            @PathVariable("id") Long id, @RequestBody ScientifcClass scientifcClass) {
        Optional<ScientifcClass> optionalScientifcClass = scientifcClassRepository.findById(id);
        if (optionalScientifcClass.isPresent()) {
            ScientifcClass existingScientifcClass = optionalScientifcClass.get();
            existingScientifcClass.setName(scientifcClass.getName());
            existingScientifcClass.setShortkey(scientifcClass.getShortkey());
            existingScientifcClass.setColor(scientifcClass.getColor());
            ScientifcClass updatedScientifcClass = scientifcClassRepository.save(existingScientifcClass);
            return new ResponseEntity<>(updatedScientifcClass, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteScientifcClass(@PathVariable("id") Long id) {
        Optional<ScientifcClass> optionalScientifcClass = scientifcClassRepository.findById(id);
        if (optionalScientifcClass.isPresent()) {
            scientifcClassRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}