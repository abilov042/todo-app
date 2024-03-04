package com.example.todoapp.repostory;

import com.example.todoapp.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyTaskDao extends JpaRepository<DailyTask, Integer> {
}
