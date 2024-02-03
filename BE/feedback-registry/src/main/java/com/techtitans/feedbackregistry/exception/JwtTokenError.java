package com.techtitans.feedbackregistry.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class JwtTokenError extends BusinessException {
    public JwtTokenError(String message) {
        super(message);
    }

    public JwtTokenError(String message, Throwable cause) {
        super(message, cause);
    }
}
