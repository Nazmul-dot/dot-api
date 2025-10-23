package com.example.DotApi.User.response;



import com.example.DotApi.User.model.UserDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.Collator;
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
    private List<String> role=new ArrayList<>();

   public UserResponse(UserDao userDao){
       this.id=userDao.getId().toString();
       this.name=userDao.getName();
       this.email=userDao.getEmail();
       this.password=userDao.getPassword();
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
