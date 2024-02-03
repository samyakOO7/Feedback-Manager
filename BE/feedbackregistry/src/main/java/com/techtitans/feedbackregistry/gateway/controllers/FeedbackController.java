package com.techtitans.feedbackregistry.gateway.controllers;

import com.techtitans.feedbackregistry.core.constants.AppConstants;
import com.techtitans.feedbackregistry.core.dtos.request.AddFeedbackRequest;
import com.techtitans.feedbackregistry.core.dtos.response.AddFeedbackResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(AppConstants.apiPathPrefix)
public class FeedbackController {

    @PostMapping(AppConstants.addFeedbackPath)
    public ResponseEntity<AddFeedbackResponse> addFeedback(@RequestBody AddFeedbackRequest addFeedbackRequest){
        return null;
    }

    @GetMapping(AppConstants.readFeedbackPath+"/{feedbackId}")
    public ResponseEntity<AddFeedbackResponse> readFeedback(@PathVariable("feedbackId") String feedbackId){
        System.out.println(feedbackId);
        return null;
    }

}
