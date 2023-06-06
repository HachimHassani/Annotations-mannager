package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ElementIdChoices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Annotation annotation;

    @ManyToMany
    private List<ElementId> elementIds;
}
