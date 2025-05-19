package com.firstwebapp.todo.ToDoapp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ToDoController {
    
    private TodoService todoService;
    public ToDoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String ListAllToDos(ModelMap model){
        // this will return the entire list of tasks
        List<Todo> todos = todoService.findByUsername("razor");
        model.put("todos",todos);
        return "listToDos";
    }
}
