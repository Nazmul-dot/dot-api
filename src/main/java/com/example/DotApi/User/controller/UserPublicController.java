package com.example.DotApi.User.controller;

import com.example.DotApi.JwtManage.JwtTokenUtil;
import com.example.DotApi.User.Interface.IUserService;
import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.response.UserResponse;
import com.example.DotApi.User.service.CustomUserDetailsService;
import com.example.DotApi.Utill.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(Common.publicRoute+"/user")
public class UserPublicController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    private final IUserService iUserService;

    public UserPublicController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testPublic(){
        return ResponseEntity.ok("ok from public");
    }

    @PostMapping("/registration")
    public ResponseEntity<?> Registration(@RequestBody User userDto) throws Exception{
        try{
            System.out.println(userDto);
            UserResponse res=iUserService.signup(userDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(res);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User userDto) throws Exception {
//        try {
//            UserResponse res = iUserService.signIn(userDto);
//            return ResponseEntity.ok(res);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }

         return iUserService.signIn(userDto);
    }

}
