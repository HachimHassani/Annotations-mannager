package com.pfa.annotationmanager.config;

import com.pfa.annotationmanager.model.ScientifcClass;
import com.pfa.annotationmanager.model.User;
import com.pfa.annotationmanager.repository.ScientificClassRepository;
import com.pfa.annotationmanager.repository.UserRepository;
import com.pfa.annotationmanager.user.Role;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class DatabaseInitializer {
    private final ScientificClassRepository scientifcClassRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public DatabaseInitializer(ScientificClassRepository scientifcClassRepository,UserRepository userRepository) {
        this.scientifcClassRepository = scientifcClassRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initializeDatabase() {
        if (scientifcClassRepository.count()==0) {
            ScientifcClass element1 = new ScientifcClass("chemical");
            ScientifcClass element2 = new ScientifcClass("desease");
            scientifcClassRepository.saveAll(List.of(element1, element2));
        }
        if (userRepository.findByEmail("admin@example.com").isEmpty()) {
            User admin = new User("John", "Doe", "admin@example.com", passwordEncoder.encode("password"), Role.ADMIN);
            userRepository.save(admin);
        }
        // more default elements can come here



    }
}
