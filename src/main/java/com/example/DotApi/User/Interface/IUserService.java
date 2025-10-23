package com.example.DotApi.User.Interface;

import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

        UserResponse signup(User user) throws Exception;
        UserResponse signIn(User user) throws Exception;
}
