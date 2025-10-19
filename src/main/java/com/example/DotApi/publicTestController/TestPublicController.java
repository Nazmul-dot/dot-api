package com.example.DotApi.publicTestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class TestPublicController {

    @GetMapping("/test")
    public String testget(){
        return "test1";
    }

    @GetMapping("/test2")
    public String testget2(){
        return "test2";
    }
}
