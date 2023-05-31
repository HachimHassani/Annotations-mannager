package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.AnnotationCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationCandidateRepository extends JpaRepository<AnnotationCandidate, Long> {
    // Add custom query methods if needed
}