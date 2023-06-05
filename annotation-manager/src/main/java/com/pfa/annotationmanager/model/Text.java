package com.pfa.annotationmanager.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "texts")

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    @Setter @Getter
    private String Title;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Setter @Getter
    private TextState state;

    @OneToMany
    private List<ExpertCandidate> candidates;


//    private List<?> annotationsBuffer;
    @Transient @Setter @Getter
    private boolean Candidated;
    public Text(String sampleText) {
        this.Title = " ";
        this.content = sampleText;
        this.state = TextState.INIT;
    }
}
