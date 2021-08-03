package com.example.Todo.repository;

import com.example.Todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<TodoEntity,Long> {


}
