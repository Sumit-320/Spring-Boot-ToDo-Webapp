package com.firstwebapp.todo.ToDoapp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
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
    // this is similar to the views.py in django- we take the req params and give the template/html with the help of data(model)
    @RequestMapping(value="add-todo",method = RequestMethod.GET)
    public String showAddToDoPage() {
        return "todo";
    }

    @RequestMapping(value="add-todo",method = RequestMethod.POST)
    public String AddToDoPage(@RequestParam String description,ModelMap model) {
        todoService.addToDo((String)model.get("name"), description, LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }
    
}
