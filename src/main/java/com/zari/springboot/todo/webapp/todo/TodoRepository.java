package com.zari.springboot.todo.webapp.todo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo,Integer> {


     List<Todo> findByUsername(String username);
}
