package com.pfa.annotationmanager.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
//@Table(name = "ElementId")
public class ElementId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String identifier;
}
