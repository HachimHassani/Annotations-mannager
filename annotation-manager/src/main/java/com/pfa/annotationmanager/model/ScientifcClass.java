package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Entity
@Table(name = "scientific_class")
public class ScientifcClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter @Getter
    private String name;

    private String Shortkey;

    private String color;

    public ScientifcClass(String name) {
        this.name = name;
    }




}
