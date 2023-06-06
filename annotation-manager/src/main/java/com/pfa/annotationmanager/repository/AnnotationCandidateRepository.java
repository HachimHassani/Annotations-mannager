package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.AnnotationCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnnotationCandidateRepository extends JpaRepository<AnnotationCandidate, Long> {
    // Add custom query methods if needed
    Optional<List<AnnotationCandidate>> findAllByExpertCandidateId(long id);
}