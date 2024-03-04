package com.example.todoapp.controller;

import com.example.todoapp.core.result.DataResult;
import com.example.todoapp.core.result.Result;
import com.example.todoapp.entity.Task;
import com.example.todoapp.service.abstracts.ITaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final ITaskService iTaskService;

    @PostMapping("/save")
    public ResponseEntity<DataResult<Task>> save(@RequestBody Task task){
        return ResponseEntity.ok(this.iTaskService.save(task));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(this.iTaskService.delete(id));
    }
}