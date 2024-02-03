package com.techtitans.feedbackregistry.gateway.services;

import com.techtitans.feedbackregistry.core.contracts.IRegisterFeedback;
import com.techtitans.feedbackregistry.core.dtos.request.AddFeedbackRequest;
import com.techtitans.feedbackregistry.core.dtos.response.AddFeedbackResponse;
import com.techtitans.feedbackregistry.core.entity.Feedback;
import com.techtitans.feedbackregistry.gateway.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.time.Instant;

public class FeedbackService implements IRegisterFeedback<AddFeedbackRequest, AddFeedbackResponse> {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public AddFeedbackResponse addFeedback(AddFeedbackRequest registerFeedbackRequest) {

        Feedback feedback = new Feedback();
        feedback.setComment(registerFeedbackRequest.getComment());
        feedback.setRating(registerFeedbackRequest.getRating());
        feedback.setCreatedTime(Timestamp.from(Instant.now()));
        feedback.setUserId(registerFeedbackRequest.getUserId());

        feedback = feedbackRepository.save(feedback);

            AddFeedbackResponse addFeedbackResponse = new AddFeedbackResponse();
            addFeedbackResponse.setId(String.valueOf(feedback.getId()));
            addFeedbackResponse.setComment(feedback.getComment());
            addFeedbackResponse.setRating(feedback.getRating());
            addFeedbackResponse.setCreatedTime(feedback.getCreatedTime());
            addFeedbackResponse.setUserId(feedback.getUserId());

            return addFeedbackResponse;
    }
}
