package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
//@Table(name = "annotation_candidate")
public class AnnotationCandidate  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer wordFrom;
    private  Integer wordTo;

    @ManyToOne
    private ScientifcClass scientifcClass;
    @ManyToOne
    private ExpertCandidate expertCandidate;


    public AnnotationCandidate() {

    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}