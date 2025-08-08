package com.kata.trello_fake_kata.infraestructure.controller;

import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.dto.TaskResponseDTO;
import com.kata.trello_fake_kata.domain.model.Task;
import com.kata.trello_fake_kata.domain.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    @Autowired
    private ITaskService taskService;

    @GetMapping
    public PagedResponse<TaskResponseDTO> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int limit) {
        return taskService.getAllTasks(page, limit);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable String id, @RequestBody Task updateTask) {
        return taskService.updateTask(id, updateTask);
    }
}
