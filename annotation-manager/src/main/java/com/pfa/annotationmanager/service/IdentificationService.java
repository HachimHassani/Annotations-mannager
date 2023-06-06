package com.pfa.annotationmanager.service;

import com.pfa.annotationmanager.model.ElementId;
import com.pfa.annotationmanager.model.ElementIdChoices;
import com.pfa.annotationmanager.repository.ElementIdChoicesRepository;
import com.pfa.annotationmanager.repository.ElementIdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class IdentificationService {
    @Autowired
    private ElementIdChoicesRepository elementIdChoicesRepository;

    private final Random random;
    private final ElementIdRepository repository;

    public IdentificationService(ElementIdRepository repository) {
        this.random = new Random();
        this.repository = repository;
    }

    public void pickRandomElements() {
        List<ElementId> allElements = repository.findAll();
        int totalElements = allElements.size();
        List<ElementIdChoices> choices = elementIdChoicesRepository.findAll();
        for (ElementIdChoices choice: choices) {
            if (choice.getElementIds().isEmpty()){
                ElementId element1 = getRandomElement(allElements, totalElements);
                ElementId element2 = getRandomElement(allElements, totalElements);
                ElementId element3 = getRandomElement(allElements, totalElements);

                List<ElementId> newList = new ArrayList<>(Arrays.asList(element1, element2, element3));
                choice.setElementIds(newList);
                System.out.println("Random elements: " + element1 + ", " + element2 + ", " + element3);
            }
        }
    }

    private ElementId getRandomElement(List<ElementId> elements, int totalElements) {
        int randomIndex = random.nextInt(totalElements);
        return elements.get(randomIndex);
    }
}

