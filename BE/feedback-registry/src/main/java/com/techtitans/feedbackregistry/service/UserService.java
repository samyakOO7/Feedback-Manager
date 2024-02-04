package com.techtitans.feedbackregistry.service;

import com.techtitans.feedbackregistry.dto.UserResponse;
import com.techtitans.feedbackregistry.entity.User;
import com.techtitans.feedbackregistry.exception.BusinessException;
import com.techtitans.feedbackregistry.exception.UserAlreadyExist;
import com.techtitans.feedbackregistry.repository.UserRepository;
import com.techtitans.feedbackregistry.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User saveCustomer(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExist("User Already Exist with email");
        }
        user.setPassword(getSecuredPassword(user.getPassword()));
        return userRepository.save(user);
    }

    public String getSecuredPassword(String password) {
        var bCryptPasswordEncoder = new BCryptPasswordEncoder(10);
        return bCryptPasswordEncoder.encode(password);

    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserResponse getUserById() {
        Long userId = ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
        var user = userRepository.findById(userId).orElseThrow(() -> new BusinessException("User Not exist with id: " + userId));
        return new UserResponse(user.getId(), user.getOrganisationName(), user.getEmail(), user.getTimeStamp());
    }


}
