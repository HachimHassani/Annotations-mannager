package com.pfa.annotationmanager.repository;
import com.pfa.annotationmanager.model.ScientifcClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScientificClassRepository extends JpaRepository<ScientifcClass, Long> {

    Optional<ScientifcClass> findByName(String name);
}