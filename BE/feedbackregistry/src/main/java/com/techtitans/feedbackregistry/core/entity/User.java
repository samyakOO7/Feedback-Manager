package com.techtitans.feedbackregistry.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// TODO: Add endpoint to sign-up
    // TODO: Add endpoint to login
    // TODO: Implement JWT auth
    // TODO: Exception handling for authentication

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
}
