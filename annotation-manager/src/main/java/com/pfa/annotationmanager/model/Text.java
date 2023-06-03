package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "texts")
public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String content;
    @Setter @Getter
    private TextState state;

    @OneToMany
    private List<ExpertCandidate> candidates;
    @Transient @Setter @Getter
    private boolean Candidated;
    public Text(String sampleText) {
        this.content = sampleText;
    }
}
