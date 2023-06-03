package com.pfa.annotationmanager.repository;
import com.pfa.annotationmanager.model.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
    // Custom query methods or additional operations can be added here if needed
}
