package com.firstwebapp.todo.ToDoapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;
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
    public String ListAllToDos(ModelMap model) {
        String username = (String)model.get("name");
        List<Todo> todos = todoService.findByUsername(username);
        model.put("todos", todos);
        return "listToDos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showAddToDoPage(Model model) {
        model.addAttribute("todo", new Todo());
        model.addAttribute("isNew", true);  // mark as adding new
        return "todo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String AddToDoPage(@ModelAttribute("todo") Todo todo, ModelMap model) {
        todoService.addToDo((String) model.get("name"), todo.getDescription(), todo.getTargetdate(), todo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String DeleteToDo(@RequestParam int id) {
        todoService.deleteToDo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String ShowUpdateToDo(@RequestParam int id, ModelMap model) {
        Todo todo = todoService.findById(id);
        model.addAttribute("todo", todo);
        model.addAttribute("isNew", false); // mark as updating
        return "todo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateToDoPage(@ModelAttribute("todo") Todo todo, ModelMap model) {
        String username = (String) model.get("name");
        todoService.updateToDo(todo.getId(), username, todo.getDescription(), todo.getTargetdate(), todo.isDone());
        return "redirect:list-todos";
    }
}
