package com.techtitans.feedbackregistry.core.dtos.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResponse {
    private String username;
    private String password;
}
