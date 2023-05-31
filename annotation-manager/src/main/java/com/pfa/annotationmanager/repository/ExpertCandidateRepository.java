package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.ExpertCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertCandidateRepository extends JpaRepository<ExpertCandidate, Long> {
}