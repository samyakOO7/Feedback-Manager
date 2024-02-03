package com.techtitans.feedbackregistry.core.entity;

import lombok.Getter;
import lombok.Setter;

    // TODO: Add endpoint to sign-up
    // TODO: Add endpoint to login
    // TODO: Implement JWT auth
    // TODO: Exception handling for authentication

@Getter
@Setter
public class User {
    private String id;
    private String username;
    private String password;
}
