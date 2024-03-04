package com.example.todoapp.service.concreates;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.SuccessDataResult;
import com.example.todoapp.entity.User;
import com.example.todoapp.repostory.UserDao;
import com.example.todoapp.service.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserDao userDao;
    @Override
    public DataResult<User> save(User user) {
        return new SuccessDataResult<>(this.userDao.save(user),"user saved");
    }
}
