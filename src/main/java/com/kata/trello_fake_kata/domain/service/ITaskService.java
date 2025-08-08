package com.kata.trello_fake_kata.domain.service;


import com.kata.trello_fake_kata.domain.dto.CreateTaskDTO;
import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.dto.TaskResponseDTO;
import com.kata.trello_fake_kata.domain.model.Task;
import org.springframework.http.ResponseEntity;

public interface ITaskService {
    PagedResponse<TaskResponseDTO> getAllTasks(int page, int limit);
    Task createTask(CreateTaskDTO task);

    Task updateTask(String id, Task updateTask);
    PagedResponse<Task>  searchUsersBySprint(String idSprint);
    ResponseEntity<String> deleteTask(String id);
}
