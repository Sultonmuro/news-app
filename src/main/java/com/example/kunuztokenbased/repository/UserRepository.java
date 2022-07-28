package com.example.kunuztokenbased.repository;

import com.example.kunuztokenbased.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhone(String username);
}
