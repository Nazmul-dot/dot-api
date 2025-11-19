package com.example.DotApi.User.controller;

import com.example.DotApi.Utill.Common;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Common.privateRoute+"/user")
public class UserPrivateController {

    @GetMapping("/test")
    public ResponseEntity<?>privateTest(){
        return ResponseEntity.ok("test from private");
    }
    @GetMapping("/test2")
    public ResponseEntity<?>privateTest2(){
        return ResponseEntity.ok("test from private");
    }


}
