package com.pfa.annotationmanager.repository;

import com.pfa.annotationmanager.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {
    // Additional custom query methods can be defined here if needed
}