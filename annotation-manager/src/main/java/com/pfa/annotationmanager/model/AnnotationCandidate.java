package com.pfa.annotationmanager.model;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor

public class AnnotationCandidate implements Serializable {

    private Integer from;
    private  Integer to;
    @ManyToOne
    private ScientifcClass scientifcClass;


}