package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "annotation")
public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "wordFrom")
    private Integer from;

    @Column(name = "wordTo")
    private  Integer to;

    @ManyToOne
    private ElementId elementId;

    @ManyToOne
    private ScientifcClass scientifcClass;
    @ManyToOne
    private Text text;

    // Constructors, getters, and setters

    public Annotation() {
    }



    // Getter and Setter methods

    public Long getId() {
        return id;
    }




    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
