package com.kata.trello_fake_kata.domain.service;

import com.kata.trello_fake_kata.domain.dto.CreateTaskDTO;
import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.dto.TaskResponseDTO;
import com.kata.trello_fake_kata.domain.model.Sprint;
import com.kata.trello_fake_kata.domain.model.Task;
import com.kata.trello_fake_kata.domain.model.User;
import com.kata.trello_fake_kata.infraestructure.persistence.SprintRepository;
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

    @Autowired
    private SprintRepository sprintRepository;
    private static final int MAX_LIMIT = 50;
    @Override
    public PagedResponse<TaskResponseDTO> getAllTasks(int page, int limit) {
        int finalLimit = Math.min(limit, MAX_LIMIT);
        Pageable pageable = PageRequest.of(page, finalLimit);
        Page<Task> tasksPage = taskRepository.findAll(pageable);

        List<TaskResponseDTO> dtoList = tasksPage.getContent().stream().map(task -> {
            Optional<User> userOpt = userRepository.findById(task.getAssignee());
            Optional<Sprint> sprintOpt = sprintRepository.findById(task.getSprint());
            String assigneeName = userOpt.map(User::getName).orElse("Desconocido");
            String sprintName = sprintOpt.map(Sprint::getName).orElse("Desconocido");
            return new TaskResponseDTO(
                    task.getId(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getPriority(),
                    assigneeName,
                    sprintName,
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
    public Task createTask(CreateTaskDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setPriority(dto.getPriority());
        task.setAssignee(dto.getAssignee());
        task.setDeliveryDate(dto.getDeliveryDate());
        task.setDueDate(dto.getDueDate());
        task.setSprint(dto.getSprint());
        task.setStatus(dto.getStatus());
        return taskRepository.save(task);
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
