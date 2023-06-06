package com.pfa.annotationmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "annotation")

public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer from;

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
