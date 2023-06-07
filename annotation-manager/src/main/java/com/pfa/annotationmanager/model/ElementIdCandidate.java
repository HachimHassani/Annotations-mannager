package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
//@Table(name = "Element_Id_Candidate")
public class ElementIdCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Annotation annotation;

    @ManyToOne
    private  ExpertCandidate expertCandidate;

    @ManyToOne
    private ElementId chosenId;
}
