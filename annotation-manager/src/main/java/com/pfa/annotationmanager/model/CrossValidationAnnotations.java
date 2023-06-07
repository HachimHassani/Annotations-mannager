package com.pfa.annotationmanager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor

public class CrossValidationAnnotations implements Serializable {

    private Integer wordFrom;
    private  Integer wordTo;

    private List<ScientifcClass> scientifcClass;

    public void addScientificClass(ScientifcClass scientifcClass){
        this.scientifcClass.add(scientifcClass);
    }


}