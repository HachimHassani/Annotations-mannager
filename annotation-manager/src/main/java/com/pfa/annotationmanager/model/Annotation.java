package com.pfa.annotationmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "annotation")
public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;


    @ManyToOne
    private Text text;

    // Constructors, getters, and setters

    public Annotation() {
    }

    public Annotation(String content, Text text) {
        this.content = content;

        this.text = text;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }
}
