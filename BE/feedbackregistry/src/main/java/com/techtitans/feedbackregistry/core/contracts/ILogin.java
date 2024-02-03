package com.techtitans.feedbackregistry.core.contracts;

public interface ILogin<req,res> {
    public res loginUser(req signInUserRequest);
}
