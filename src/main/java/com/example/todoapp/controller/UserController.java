package com.example.todoapp.controller;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.entity.User;
import com.example.todoapp.service.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService iUserService;

    @PostMapping("/save")
    public ResponseEntity<DataResult<User>> save(@RequestBody User user){
        return ResponseEntity.ok(iUserService.save(user));
    }
}
