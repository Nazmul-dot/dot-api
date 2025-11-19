package com.example.DotApi.User.response;



import com.example.DotApi.User.dto.User;
import com.example.DotApi.User.model.UserDao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.Collator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Dhaka")
    private LocalDateTime created;
    private List<String> role=new ArrayList<>();

   public UserResponse(UserDao userDao){
       this.id=userDao.getId().toString();
       this.name=userDao.getName();
       this.email=userDao.getEmail();
       this.password=userDao.getPassword();
       this.created=userDao.getCreatedAt();
   }

   public UserResponse ConvertDaoToResponse(UserDao userDao){
       UserResponse response= new UserResponse();

       response.setId(userDao.getId().toString());
       response.setEmail(userDao.getEmail());
       response.setName(userDao.getName());
       response.setPassword(userDao.getPassword());
       response.setCreated(userDao.getCreatedAt());
       return response;
   }

   public List<UserResponse> getAllUser(List<UserDao> userDaoList){
//       List<UserResponse> allUser=new ArrayList<>();
//       for(UserDao user:userDaoList){
//           allUser.add(new UserResponse((user)));
//       }

       List<UserResponse> allUser = userDaoList.stream()
               .map(user -> new UserResponse(user))
               .collect(Collectors.toList());
       return allUser;
   }
}
