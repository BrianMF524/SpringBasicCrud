package com.restexplorer.app.rest.controller;


import com.restexplorer.app.rest.model.Task;
import com.restexplorer.app.rest.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping(value = "/")
    public String test(){
        return "Probando";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    @PostMapping("/tasks/post")
    public String saveTask(@RequestBody Task task){
        taskRepo.save(task);
        return "Tarea guardada";
    }

    @PutMapping("/tasks/update/{id}")
    public String updateTask(@PathVariable long id,@RequestBody Task task){
        Task tareaActualizada =taskRepo.findById(id).get();
        tareaActualizada.setTitulo(task.getTitulo());
        tareaActualizada.setDescripcion(task.getDescripcion());
        taskRepo.save(tareaActualizada);
        return "Tarea actualizada";
    }
    @DeleteMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable long id){
        Task deleteTask= taskRepo.findById(id).get();
        taskRepo.delete(deleteTask);
        return "Tarea eliminada";
    }
}
