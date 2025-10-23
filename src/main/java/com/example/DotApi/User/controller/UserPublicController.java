package com.example.DotApi.User.controller;

import com.example.DotApi.User.Interface.IUserService;
import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.response.UserResponse;
import com.example.DotApi.Utill.Common;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Common.publicRoute+"/user")
public class UserPublicController {

    private final IUserService iUserService;

    public UserPublicController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping("/test")
    public ResponseEntity<?> testPublic(){
        return ResponseEntity.ok("ok from public");
    }

    @PostMapping("/registration")
    public ResponseEntity<?> Registration(@RequestBody User user) throws Exception{
        try{
            System.out.println(user);
            UserResponse res=iUserService.signup(user);

            return ResponseEntity.status(HttpStatus.CREATED).body(res);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            UserResponse res = iUserService.signIn(user);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
