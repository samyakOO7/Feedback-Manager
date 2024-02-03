package com.techtitans.feedbackregistry.service;

import com.techtitans.feedbackregistry.entity.Feedback;
import com.techtitans.feedbackregistry.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback) {
        feedback.setCreatedTime(Timestamp.from(Instant.now()));
        return feedbackRepository.save(feedback);
    }
}
