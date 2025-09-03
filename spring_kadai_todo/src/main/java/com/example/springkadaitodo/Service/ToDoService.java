package com.example.springkadaitodo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springkadaitodo.Entity.ToDo;
import com.example.springkadaitodo.Repository.ToDoRepository;

@Service
public class ToDoService {
	
	private final ToDoRepository toDoRepository;

	public ToDoService(ToDoRepository toDoRepository) {
	this.toDoRepository = toDoRepository;
	}
	
	public  List<ToDo> getAllToDos(){
		 return toDoRepository.findAll();
	}
}
