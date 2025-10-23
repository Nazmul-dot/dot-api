package com.example.DotApi.User.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {

    private String name;
    private String email;
    private String password;
    private String role;
}
