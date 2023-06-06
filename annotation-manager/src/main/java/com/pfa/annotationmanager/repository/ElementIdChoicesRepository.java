package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.ElementIdChoices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementIdChoicesRepository extends JpaRepository<ElementIdChoices, Long> {
}
