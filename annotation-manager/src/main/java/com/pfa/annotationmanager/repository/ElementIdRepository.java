package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.ElementId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ElementIdRepository extends JpaRepository<ElementId, Long> {

}
