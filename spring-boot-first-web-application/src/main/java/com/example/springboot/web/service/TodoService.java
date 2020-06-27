package com.example.springboot.web.service;

import java.util.ArrayList;
import java.util.*;

import org.springframework.stereotype.Service;

import com.example.springboot.web.model.Todo;

@Service
public class TodoService {

	private static List<Todo> todos=new ArrayList<Todo>();
	
	private static int todoCount=3;
	
	static {
		todos.add(new Todo(1,"sankalp","learn spring boot", new Date(),false));
		todos.add(new Todo(1,"arpit","learn spring boot", new Date(),false));
		
		todos.add(new Todo(1,"shank","learn spring boot", new Date(),false));
		todos.add(new Todo(1,"sam","learn spring boot", new Date(),false));
		
	}
	
	public List<Todo> retrieveTodos(){	
		List<Todo> filteredTodos =new ArrayList<Todo>();
		/*
		 * for(Todo todo: todos) { if(todo.getUser().contentEquals(user)){
		 * filteredTodos.add(todo); } }
		 */
		return filteredTodos;
	}
	
    
    public Todo retrieveTodo(int id) {
        for (Todo todo : todos) {
            if (todo.getId()==id) {
                return todo;
            }
        }
        return null;
    }
    
    public void updateTodo(Todo todo){
		todos.remove(todo);
		todos.add(todo);
}
	
	public void addTodo(String name, String desc, Date targetDate,boolean isDone) {
		todos.add(new Todo(++todoCount,name,desc,targetDate,isDone));
	}
	
	public void deleteTodo(int id) {
		
		Iterator<Todo> iterator=todos.iterator();
		
		while(iterator.hasNext()) {
		Todo todo=iterator.next();
		if(todo.getId()==id) {
			iterator.remove();
		}
		}
		
	}
	
}
