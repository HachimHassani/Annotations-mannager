package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class AnnotationCandidate  {

    private Integer from;
    private  Integer to;

    @ManyToOne
    private ScientifcClass scientifcClass;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public AnnotationCandidate() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}