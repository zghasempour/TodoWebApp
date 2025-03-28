package com.zari.springboot.todo.webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class todoController {
	

	public todoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}
	private TodoService todoService;
	
	@RequestMapping("todo-list")
	public String listAllTodos(ModelMap model) {
		String username = getLoggedInUsername();
		List<Todo> todoList = todoService.findByUsername(username);
		model.addAttribute("todoList", todoList);
		
		return "todoList";
	}

	private static String getLoggedInUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}


	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username = getLoggedInUsername();
		Todo todo = new Todo(0,username, "",LocalDate.now().plusYears(1), false);
		model.put("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername();
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:todo-list";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:todo-list";
	}

	
	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}

		String username = getLoggedInUsername();
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:todo-list";
	}
}
