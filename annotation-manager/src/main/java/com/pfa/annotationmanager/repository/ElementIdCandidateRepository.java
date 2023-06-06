package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.ElementIdCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementIdCandidateRepository extends JpaRepository<ElementIdCandidate, Long> {
}
