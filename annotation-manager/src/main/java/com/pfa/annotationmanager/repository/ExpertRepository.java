package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    // Additional custom query methods can be defined here if needed
}