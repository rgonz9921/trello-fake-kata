package com.kata.trello_fake_kata.domain.service;

import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.dto.TaskResponseDTO;
import com.kata.trello_fake_kata.domain.model.Task;
import com.kata.trello_fake_kata.domain.model.User;
import com.kata.trello_fake_kata.infraestructure.persistence.TaskRepository;
import com.kata.trello_fake_kata.infraestructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;
    private static final int MAX_LIMIT = 50;
    @Override
    public PagedResponse<TaskResponseDTO> getAllTasks(int page, int limit) {
        int finalLimit = Math.min(limit, MAX_LIMIT);
        Pageable pageable = PageRequest.of(page, finalLimit);
        Page<Task> tasksPage = taskRepository.findAll(pageable);

        List<TaskResponseDTO> dtoList = tasksPage.getContent().stream().map(task -> {
            Optional<User> userOpt = userRepository.findById(task.getAssignee());
            String assigneeName = userOpt.map(User::getName).orElse("Desconocido");
            return new TaskResponseDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getPriority(),
                    assigneeName,
                    task.getDeliveryDate(),
                    task.getDueDate(),
                    task.getSprint(),
                    task.getStatus()
            );
        }).toList();
        return new PagedResponse<>(
                "tasks",
                dtoList,
                page,
                finalLimit,
                tasksPage.getTotalElements()
        );
    }


    @Override
    public Task createTask(Task task) {
        return null;
    }

    @Override
    public Task updateTask(String id, Task updateTask) {
        return null;
    }

    @Override
    public PagedResponse<Task> searchUsersBySprint(String idSprint) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteTask(String id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            taskRepository.deleteById(id);
            return ResponseEntity.accepted().body("Task with ID " + id + " was successfully deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with ID " + id + " not found.");
        }
    }
}
