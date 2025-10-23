package com.example.DotApi.User.service;

import com.example.DotApi.User.Interface.IUserService;
import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.model.UserDao;
import com.example.DotApi.User.repo.UserRepository;
import com.example.DotApi.User.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse signup(User user) throws Exception {
        try {
            UserDao userExis=userRepository.findByEmail(user.getEmail());
            if(userExis != null){
                throw new Exception("User already exists");
            }
            UserDao respon=new UserDao();
            respon.setName(user.getName());
            respon.setEmail(user.getEmail());
            respon.setPassword(passwordEncoder.encode(user.getPassword()));
            respon.setRole(Boolean.parseBoolean(user.getRole()) ?user.getRole():"user");
            UserDao result=userRepository.save(respon);
            return new UserResponse(result);
        }catch (Exception e){
            throw new Exception("Failed in user signUp");
        }

    }

    @Override
    public UserResponse signIn(User user) throws Exception {
        UserDao userDao = userRepository.findByEmail(user.getEmail());
        if (userDao == null) {
            throw new Exception("User is not registered");
        }
        // ✅ Correct order: rawPassword first, encodedPassword second
        if (!passwordEncoder.matches(user.getPassword(), userDao.getPassword())) {
            throw new Exception("Invalid credentials");
        }

        return new UserResponse(userDao);
    }
}
