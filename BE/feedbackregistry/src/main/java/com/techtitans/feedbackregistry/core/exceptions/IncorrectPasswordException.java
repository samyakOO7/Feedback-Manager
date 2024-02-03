package com.techtitans.feedbackregistry.core.exceptions;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException(){
        super("Password is incorrect, please check and retry");
    }
}
