package com.techtitans.feedbackregistry.controller;

import com.techtitans.feedbackregistry.dto.JwtAuthRequest;
import com.techtitans.feedbackregistry.dto.JwtAuthResponse;
import com.techtitans.feedbackregistry.dto.UserRegistration;
import com.techtitans.feedbackregistry.dto.UserResponse;
import com.techtitans.feedbackregistry.entity.User;
import com.techtitans.feedbackregistry.service.MyUserDetailsService;
import com.techtitans.feedbackregistry.service.UserService;
import com.techtitans.feedbackregistry.util.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserService userService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/registration")
    public ResponseEntity<User> userRegistration(@RequestBody UserRegistration user) {
        return ResponseEntity.ok(userService.saveCustomer(modelMapper.map(user, User.class)));
    }

    @PostMapping("/login")
    public ResponseEntity<Object> generateToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws AuthenticationException {
        try{
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    jwtAuthRequest.getUsername(),
                    jwtAuthRequest.getPassword()));
        } catch(UsernameNotFoundException | BadCredentialsException e) {
            return ResponseEntity.badRequest().body("Bad Credentials");
        }

        var userDetails = this.userDetailsService.loadUserByUsername(jwtAuthRequest.getUsername());

        var user = userService.getUserByEmail(jwtAuthRequest.getUsername());
        if(user.isPresent()) {
            String token = jwtUtils.generateToken(userDetails, user.get());
            return ResponseEntity.ok(new JwtAuthResponse(token, user.get()));
        }
        return ResponseEntity.status(402).body("user is null");
    }

    @GetMapping("/authenticate/user")
    public ResponseEntity<UserResponse> getUserById() throws AuthenticationException {
        return ResponseEntity.status(200).body(userService.getUserById());
    }
}
