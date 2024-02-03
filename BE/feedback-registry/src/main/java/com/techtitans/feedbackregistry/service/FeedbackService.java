package com.techtitans.feedbackregistry.service;

import com.techtitans.feedbackregistry.entity.Feedback;
import com.techtitans.feedbackregistry.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
