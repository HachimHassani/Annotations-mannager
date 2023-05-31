package com.pfa.annotationmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "annotation_candidate")
public class AnnotationCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expert_candidate_id")
    private ExpertCandidate expertCandidate;

    // Constructors, getters, and setters

    public Long getId() {
        return id;
    }

    public ExpertCandidate getExpertCandidate() {
        return expertCandidate;
    }

    public void setExpertCandidate(ExpertCandidate expertCandidate) {
        this.expertCandidate = expertCandidate;
    }
}