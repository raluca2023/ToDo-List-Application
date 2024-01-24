package com.example.ToDo.List.App.repository;

import com.example.ToDo.List.App.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {
}
