package com.example.TodoApplication.Service;

import com.example.TodoApplication.Entity.Todo;
import com.example.TodoApplication.Repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepo todoRepo;
    public void saveTodo(Todo todo) {
        todoRepo.save(todo);
    }

    public List<Todo> getAllTodo() {
        return todoRepo.findAll();
    }

    public void updateTodo(long id, Todo newtodo) {
        Optional<Todo> todoOldBox=todoRepo.findById(id);
        if(todoOldBox.isPresent()){
            Todo oldTodo=todoOldBox.get();
            oldTodo.setTaskContent(newtodo.getTaskContent());
            todoRepo.update(oldTodo);
        }
    }

    public void delete(long id) {
        todoRepo.delTodo(id);
    }
}
