package com.pfa.annotationmanager.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TextState {
    INIT("init"),
    REVIEW("review"),
    ANNOTATED("Annotated"),
    IDCANDIDATED("IdCandidated"),
    IDASSIGNED("idAssigned");

    @Getter
    private final String state;


}
