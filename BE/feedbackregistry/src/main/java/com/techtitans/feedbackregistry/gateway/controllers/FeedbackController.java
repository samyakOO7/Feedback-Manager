package com.techtitans.feedbackregistry.gateway.controllers;

import com.techtitans.feedbackregistry.core.constants.AppConstants;
import com.techtitans.feedbackregistry.core.dtos.request.AddFeedbackRequest;
import com.techtitans.feedbackregistry.core.dtos.response.AddFeedbackResponse;
import com.techtitans.feedbackregistry.gateway.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(AppConstants.apiPathPrefix)
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(AppConstants.addFeedbackPath)
    public ResponseEntity<AddFeedbackResponse> addFeedback(@RequestBody AddFeedbackRequest addFeedbackRequest){
        return ResponseEntity.ok().body(feedbackService.addFeedback(addFeedbackRequest));
    }

    @GetMapping(AppConstants.readFeedbackPath+"/{feedbackId}")
    public ResponseEntity<AddFeedbackResponse> readFeedback(@PathVariable("feedbackId") String feedbackId){
        System.out.println(feedbackId);
        return null;
    }

}
