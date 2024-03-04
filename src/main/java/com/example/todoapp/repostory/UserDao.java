package com.example.todoapp.repostory;

import com.example.todoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
