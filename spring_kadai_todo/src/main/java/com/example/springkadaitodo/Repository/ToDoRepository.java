package com.example.springkadaitodo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springkadaitodo.Entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
List<ToDo> findByTitle(String title);
}
