package com.example.todoapp.service.abstracts;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.entity.User;

public interface IUserService {
    DataResult<User> save(User user);
}
