package com.example.todoapp.service.concreates;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.Result;
import com.example.todoapp.core.result.SuccessDataResult;
import com.example.todoapp.core.result.SuccessResult;
import com.example.todoapp.entity.Task;
import com.example.todoapp.repostory.TaskDao;
import com.example.todoapp.service.abstracts.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final TaskDao taskDao;
    @Override
    public DataResult<Task> save(Task task) {
        return new SuccessDataResult<>(this.taskDao.save(task), "created task");
    }

    @Override
    public Result delete(int id) {
        this.taskDao.deleteById(id);
        return new SuccessResult("task deleted");
    }

    @Override
    public DataResult<Task> update(Task task) {
        return new SuccessDataResult<>(this.taskDao.save(task), "task updated");
    }
}
