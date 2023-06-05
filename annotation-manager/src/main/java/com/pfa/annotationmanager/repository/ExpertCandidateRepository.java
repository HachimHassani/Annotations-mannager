package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.Expert;
import com.pfa.annotationmanager.model.ExpertCandidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpertCandidateRepository extends JpaRepository<ExpertCandidate, Long> {

    Optional<List<ExpertCandidate>> findAllByExpert(Expert expert);


    Optional<ExpertCandidate> findByExpertAndTextId(Expert expert,Long TextId);
}