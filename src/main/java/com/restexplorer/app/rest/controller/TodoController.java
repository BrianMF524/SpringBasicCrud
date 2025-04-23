package com.restexplorer.app.rest.controller;


import com.restexplorer.app.rest.model.Task;
import com.restexplorer.app.rest.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping(value = "/todo")
    public String test(){
        return "Probando";
    }
    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }
    @PostMapping("/saveTask")
    public String saveTask(@RequestBody Task task){

        taskRepo.save(task);
        return "Tarea guardada";
    }
    /*@GetMapping("/testLombok")
    public String testGetter() {
        Task t = new Task();
        t.setTitulo("Funciona");
        return t.getTitulo(); // Esto debe funcionar sin errores
    }*/
}
