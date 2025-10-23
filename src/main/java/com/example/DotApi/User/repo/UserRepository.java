package com.example.DotApi.User.repo;

import com.example.DotApi.User.model.UserDao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDao, UUID> {
    UserDao findByEmail(String email);
}
