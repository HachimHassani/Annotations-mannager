package com.pfa.annotationmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class ExpertCandidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection @Setter @Getter
    private List<AnnotationCandidate> annotationCandidates;
    @ManyToOne
    private Text text;

    @Setter @Getter
    private TextState annotationstate;
    @JsonIgnore
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

}