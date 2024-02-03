package com.techtitans.feedbackregistry.core.contracts;

public interface ILogin<req,res> {
    public res addUser(req signInUserRequest);
}
