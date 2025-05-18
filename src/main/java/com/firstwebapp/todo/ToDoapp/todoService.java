package com.firstwebapp.todo.ToDoapp;
import java.time.LocalDate;
import java.util.List;

public class todoService {
    public static List<todo>todos;
    static{
        todos.add(new todo(1,"razor","intermediate driving",LocalDate.now().plusYears(2),false));
        todos.add(new todo(2,"charlie","amateur piano",LocalDate.now().plusYears(1),false));
        todos.add(new todo(3,"alpha","intermediate programming",LocalDate.now().plusYears(3),false));
    }

    public List<todo> findByUsername(String username){
        return todos;
    }
}
