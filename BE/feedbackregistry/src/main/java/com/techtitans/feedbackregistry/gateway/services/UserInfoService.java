package com.techtitans.feedbackregistry.gateway.services;

import com.techtitans.feedbackregistry.core.contracts.ILogin;
import com.techtitans.feedbackregistry.core.contracts.ISignUp;
import com.techtitans.feedbackregistry.core.dtos.request.AddUserRequest;
import com.techtitans.feedbackregistry.core.dtos.request.UserLoginRequest;
import com.techtitans.feedbackregistry.core.dtos.response.AddUserResponse;
import com.techtitans.feedbackregistry.core.dtos.response.UserLoginResponse;
import com.techtitans.feedbackregistry.core.entity.User;
import com.techtitans.feedbackregistry.core.exceptions.IncorrectPasswordException;
import com.techtitans.feedbackregistry.core.exceptions.InvalidRequestException;
import com.techtitans.feedbackregistry.core.exceptions.UserNotFoundException;
import com.techtitans.feedbackregistry.gateway.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService implements ISignUp<AddUserRequest, AddUserResponse>, ILogin<UserLoginRequest, UserLoginResponse>, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private Authentication authentication;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;




    @Override
    public UserLoginResponse loginUser(UserLoginRequest signInUserRequest) {

        // perform password validation
        User user = userRepository
                              .findByUserName(signInUserRequest.getUsername())
                              .orElseThrow(()-> new UserNotFoundException("UserName:- "+signInUserRequest.getUsername()+" does not exist"));

        if(encoder.matches(signInUserRequest.getPassword(), user.getPassword())){
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInUserRequest.getUsername(), signInUserRequest.getPassword()));
            String token = null;
            if(auth.isAuthenticated()){
                token = jwtService.generateToken(signInUserRequest.getUsername());
                UserLoginResponse userLoginResponse = new UserLoginResponse();
                userLoginResponse.setUsername(signInUserRequest.getUsername());
                userLoginResponse.setUserId(String.valueOf(user.getId()));
                userLoginResponse.setToken(token);
                return userLoginResponse;
            }else{
                throw new InvalidRequestException("Invalid Request");
            }
        }else{
            throw new IncorrectPasswordException();
        }
    }

    @Override
    public AddUserResponse signUp(AddUserRequest addUserRequest) {
        User newUser = new User();

        newUser.setUsername(addUserRequest.getUsername());
        newUser.setPassword(encoder.encode(addUserRequest.getPassword()));
        newUser = userRepository.save(newUser);

        AddUserResponse response = new AddUserResponse();
        response.setId(String.valueOf(newUser.getId()));
        response.setUsername(newUser.getUsername());

        return response;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username).orElseThrow(()-> new UserNotFoundException("User not found"));
        return  new UserInfoDetails(user);
    }
}
