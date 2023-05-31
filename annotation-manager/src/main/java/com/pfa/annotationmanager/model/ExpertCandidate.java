package com.pfa.annotationmanager.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ExpertCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "expertCandidate", cascade = CascadeType.ALL)
    private List<AnnotationCandidate> annotationCandidates;
    @ManyToOne
    private Text text;

    @ManyToOne
    private Expert expert;

    public Long getId() {
        return id;
    }

    public Text getText()  {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }

    public List<AnnotationCandidate> getAnnotationCandidates() {
        return annotationCandidates;
    }

    public void setAnnotationCandidates(List<AnnotationCandidate> annotationCandidates) {
        this.annotationCandidates = annotationCandidates;
    }
}