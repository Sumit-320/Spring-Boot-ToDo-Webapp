package com.firstwebapp.todo.ToDoapp;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TodoService {
    private static List<Todo>todos=new ArrayList<>();
    private static int todosCount=0;


    static{
        todos.add(new Todo(++todosCount,"razor","intermediate driving",LocalDate.now().plusYears(2),false));
        todos.add(new Todo(++todosCount,"charlie","amateur piano",LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todosCount,"alpha","intermediate programming",LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }

    public void addToDo(String username, String description, LocalDate targetdate,boolean done){
        Todo todo = new Todo(++todosCount,username,description,targetdate,done);
        todos.add(todo); // appending the list
    } 
    public void deleteToDo(int id){
        Predicate<? super Todo>predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }
}
