package com.techtitans.feedbackregistry.controller;

import com.techtitans.feedbackregistry.dto.FeedbackRequest;
import com.techtitans.feedbackregistry.entity.Feedback;
import com.techtitans.feedbackregistry.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/feedback")
    public ResponseEntity<String> addFeedback(@RequestBody FeedbackRequest feedback) {
        feedbackService.addFeedback(modelMapper.map(feedback, Feedback.class));
        return new ResponseEntity<>("Feedback Added", HttpStatus.CREATED);
    }
}
