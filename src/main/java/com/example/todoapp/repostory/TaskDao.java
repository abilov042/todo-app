package com.example.todoapp.repostory;

import com.example.todoapp.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Integer> {
    void deleteById(int id);
}
