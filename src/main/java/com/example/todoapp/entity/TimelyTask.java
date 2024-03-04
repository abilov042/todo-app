package com.example.todoapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name ="timely_tasks")
@AllArgsConstructor
@NoArgsConstructor
public class TimelyTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
