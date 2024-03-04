package com.example.todoapp.service.abstracts;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.Result;
import com.example.todoapp.dto.SaveDailyTaskDto;
import com.example.todoapp.dto.TaskResponseDto;
import com.example.todoapp.entity.Task;

public interface ITaskService {
    DataResult<TaskResponseDto> saveDailyTask(SaveDailyTaskDto saveDailyTaskDto);
    Result delete(int id);
    DataResult<Task> update(Task task);
}
