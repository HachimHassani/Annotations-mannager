package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.Expert;
import com.pfa.annotationmanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {
    // Additional custom query methods can be defined here if needed
    Optional<Expert> findByEmail(String email);
}