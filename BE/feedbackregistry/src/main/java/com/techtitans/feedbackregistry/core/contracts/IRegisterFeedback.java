package com.techtitans.feedbackregistry.core.contracts;

public interface IRegisterFeedback<req, res> {
    public res addFeedback(req registerFeedbackRequest);
}
