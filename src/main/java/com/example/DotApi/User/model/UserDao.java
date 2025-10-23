package com.example.DotApi.User.model;


import com.example.DotApi.User.dto.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="dot_user")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDao extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false,name="user_name")
    private String name;

    @Column(nullable = false,name="password")
    private String password;

    @Column(nullable = false,name="email")
    private String email;

    @Column(name="Role")
    private String role;

    public UserDao(User userdto){
        this.name=userdto.getName();
        this.email=userdto.getEmail();
        this.password=userdto.getPassword();
        if(userdto.getRole()!=null && !userdto.getRole().isEmpty()){
            this.role = userdto.getRole();
        }else {
            this.role="user";
        }
    }
}
