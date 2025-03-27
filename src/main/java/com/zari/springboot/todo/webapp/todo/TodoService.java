package com.zari.springboot.todo.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int todoId = 0;
	static {
		todos.add(new Todo(++todoId, "Zahra", "Learning Java", LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++todoId, "Zahra", "Learning Swift", LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++todoId, "Zahra", "Learning Flutter", LocalDate.now().plusYears(3),false));
	}
	public List<Todo> findByUsername(String name){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(name);
		return todos.stream().filter(predicate).toList();

	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone)
	{
		Todo todo = new Todo(++todoId, username, description, targetDate, isDone);
		todos.add(todo);
	}

	public void deleteById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}

	public void updateTodo(Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}
}
