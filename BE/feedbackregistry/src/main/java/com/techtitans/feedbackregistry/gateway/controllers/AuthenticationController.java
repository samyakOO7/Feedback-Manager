package com.techtitans.feedbackregistry.gateway.controllers;

import com.techtitans.feedbackregistry.core.constants.AppConstants;
import com.techtitans.feedbackregistry.core.dtos.request.AddUserRequest;
import com.techtitans.feedbackregistry.core.dtos.response.AddUserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(AppConstants.apiAuthPathPrefix)
@RestController
public class AuthenticationController {

    @PostMapping(AppConstants.signUpPath)
    public ResponseEntity<AddUserResponse> registerUser(@RequestBody AddUserRequest addUserRequest){
        System.out.println(addUserRequest);
        return ResponseEntity.ok(new AddUserResponse());
    }


}
