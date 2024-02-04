package com.techtitans.feedbackregistry.service;

import com.techtitans.feedbackregistry.dto.RatingCount;
import com.techtitans.feedbackregistry.entity.Feedback;
import com.techtitans.feedbackregistry.repository.FeedbackRepository;
import com.techtitans.feedbackregistry.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback addFeedback(Feedback feedback) {
        feedback.setCreatedTime(Timestamp.from(Instant.now()));
        return feedbackRepository.save(feedback);
    }

    public List<FeedbackRepository.RatingCountProjection> getUsersFeedback(){
        Long userId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
        List<FeedbackRepository.RatingCountProjection> ratingCount = new ArrayList<>();
        feedbackRepository.findByUserId(userId).forEach(ratingCount::add);
        return ratingCount;
    }
}
