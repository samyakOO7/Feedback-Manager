package com.techtitans.feedbackregistry.core.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    private String username;
    private String password;
}
