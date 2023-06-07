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
    @Column(name = "wordFrom")
    private Integer start;
    @Column(name = "wordTo")
    private  Integer end;

    @ManyToOne
    private ScientifcClass scientifcClass;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ExpertCandidate expertCandidate;


    public AnnotationCandidate() {

    }

    public void setTag(String text){

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}