package com.firstwebapp.todo.ToDoapp;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class TodoService {
    public static List<Todo>todos=new ArrayList<>();
    static{
        todos.add(new Todo(1,"razor","intermediate driving",LocalDate.now().plusYears(2),false));
        todos.add(new Todo(2,"charlie","amateur piano",LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3,"alpha","intermediate programming",LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUsername(String username){
        return todos;
    }
}
