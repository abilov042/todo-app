package com.example.todoapp.service.abstracts;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.Result;
import com.example.todoapp.entity.Task;

public interface ITaskService {
    DataResult<Task> save(Task task);
    Result delete(int id);
    DataResult<Task> update(Task task);
}
