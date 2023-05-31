package com.pfa.annotationmanager.repository;
import com.pfa.annotationmanager.model.ScientifcClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientificClassRepository extends JpaRepository<ScientifcClass, Long> {

}