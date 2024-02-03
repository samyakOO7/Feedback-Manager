package com.techtitans.feedbackregistry.core.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String message){
        super(message);
    }
}
