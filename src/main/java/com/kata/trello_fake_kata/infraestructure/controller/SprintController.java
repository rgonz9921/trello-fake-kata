package com.kata.trello_fake_kata.infraestructure.controller;

import com.kata.trello_fake_kata.domain.model.Sprint;
import com.kata.trello_fake_kata.domain.service.ISprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/sprints")
public class SprintController {

    @Autowired
    private ISprintService sprintService;

    @GetMapping
    public List<Sprint> getAllSprint(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int limit) {
        return sprintService.getAllSprints(page, limit);
    }
}
