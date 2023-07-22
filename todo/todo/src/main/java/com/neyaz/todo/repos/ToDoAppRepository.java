package com.neyaz.todo.repos;

import com.neyaz.todo.model.ToDoApp;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoAppRepository extends JpaRepository<ToDoApp, Long> {
}
