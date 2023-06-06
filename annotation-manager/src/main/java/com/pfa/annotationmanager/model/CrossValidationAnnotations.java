package com.pfa.annotationmanager.model;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor

public class CrossValidationAnnotations implements Serializable {

    private Integer from;
    private  Integer to;

    private List<ScientifcClass> scientifcClass;

    public void addScientificClass(ScientifcClass scientifcClass){
        this.scientifcClass.add(scientifcClass);
    }


}