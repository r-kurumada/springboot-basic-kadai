package com.example.springkadaitodo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.Entity.ToDo;
import com.example.springkadaitodo.Service.ToDoService;

@Controller
public class ToDoController {

	private final ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		this.toDoService = toDoService;
	}
	
	@GetMapping("/todo")
	public String todo(Model model) {
		List<ToDo> todo = toDoService.getAllToDos();
		
		model.addAttribute("todo", todo);
		
		return "ToDoView";
	}
}
