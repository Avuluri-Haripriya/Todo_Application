package com.example.TodoApplication.TodoController;

import com.example.TodoApplication.Entity.Todo;
import com.example.TodoApplication.Service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoCon {

    @Autowired
    TodoService todoService;

    @RequestMapping("/")
    public String getAllTodos(Model model){
        List<Todo> listOfTodos=todoService.getAllTodo();
        model.addAttribute("TodoList",listOfTodos);
        return "Task";
    }

    @RequestMapping(value ="/addtodo",method = RequestMethod.POST)
    @ResponseBody
    public String createTodo(@ModelAttribute Todo todo){
        todoService.saveTodo(todo);
        return "redirect:/";

    }
    @RequestMapping(value = "/updatetodo/{id}")
    public String updatetodo(@PathVariable("id") long id,@ModelAttribute Todo todo){
        todoService.updateTodo(id,todo);
        return "redirect:/";
    }

    @RequestMapping(value = "/deletetodo/{id}")
    public String deleteTodo(@PathVariable("id") long id){
        todoService.delete(id);
        return "redirect:/";
    }


}
