package com.techtitans.feedbackregistry.controller;

import com.techtitans.feedbackregistry.dto.FeedbackRequest;
import com.techtitans.feedbackregistry.dto.RatingCount;
import com.techtitans.feedbackregistry.entity.Feedback;
import com.techtitans.feedbackregistry.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> addFeedback(@RequestBody FeedbackRequest feedback) {
        return new ResponseEntity<>(feedbackService.addFeedback(modelMapper.map(feedback, Feedback.class)), HttpStatus.CREATED);
    }

    @GetMapping("/authenticate/rating_count")
    public ResponseEntity<Object> getRatingCount(){
        return  ResponseEntity.ok().body(feedbackService.getUsersFeedback());
    }
}
