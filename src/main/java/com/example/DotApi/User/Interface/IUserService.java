package com.example.DotApi.User.Interface;

import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

        UserResponse signup(User userDto) throws Exception;
//        UserResponse signIn(User userDto) throws Exception;
        ResponseEntity<?>signIn(User userDto) throws Exception;
}
