package com.techtitans.feedbackregistry.core.contracts;

public interface ISignUp<req, res>{
    public res signUp(req addUserRequest);
}
