package com.example.todoapp.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "daily_tasks")
@AllArgsConstructor
@NoArgsConstructor
public class DailyTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "expire_date")
    private LocalDateTime expireDate;

    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public void setExpireDate(){
        this.expireDate = LocalDateTime.of(LocalDateTime.now().toLocalDate(), LocalTime.MIDNIGHT);
    }
}
