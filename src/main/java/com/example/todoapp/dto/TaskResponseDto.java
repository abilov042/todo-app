package com.example.todoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {
    private int id;
    private String task;
    private LocalDateTime createdAt;
    private LocalDateTime expireDate;
}
