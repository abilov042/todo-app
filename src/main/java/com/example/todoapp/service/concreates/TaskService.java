package com.example.todoapp.service.concreates;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.Result;
import com.example.todoapp.core.result.SuccessDataResult;
import com.example.todoapp.core.result.SuccessResult;
import com.example.todoapp.dto.SaveDailyTaskDto;
import com.example.todoapp.dto.TaskResponseDto;
import com.example.todoapp.entity.DailyTask;
import com.example.todoapp.entity.Task;
import com.example.todoapp.entity.User;
import com.example.todoapp.repostory.DailyTaskDao;
import com.example.todoapp.repostory.TaskDao;
import com.example.todoapp.repostory.UserDao;
import com.example.todoapp.service.abstracts.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService implements ITaskService {

    private final TaskDao taskDao;
    private final UserDao userDao;
    private final DailyTaskDao dailyTaskDao;


    @Override
    public DataResult<TaskResponseDto> saveDailyTask(SaveDailyTaskDto saveDailyTaskDto) {
        Task task = new Task();
        task.setTask(saveDailyTaskDto.getTask());
        User user = userDao.findById(saveDailyTaskDto.getUserId()).orElseThrow();
        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());

        Task taskForDaily = this.taskDao.save(task);

        DailyTask dailyTask = new DailyTask();
        dailyTask.setExpireDate();
        dailyTask.setTask(taskForDaily);
        this.dailyTaskDao.save(dailyTask);

        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setTask(taskForDaily.getTask());
        taskResponseDto.setId(taskForDaily.getId());
        taskResponseDto.setCreatedAt(taskForDaily.getCreatedAt());
        taskResponseDto.setExpireDate(dailyTask.getExpireDate());

        return new SuccessDataResult<>(taskResponseDto, "task created");
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
