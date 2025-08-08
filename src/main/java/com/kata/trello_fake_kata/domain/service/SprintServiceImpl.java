package com.kata.trello_fake_kata.domain.service;

import com.kata.trello_fake_kata.domain.model.Sprint;
import com.kata.trello_fake_kata.infraestructure.persistence.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImpl implements ISprintService{

    @Autowired
    private SprintRepository sprintRepository;

    @Override
    public List<Sprint> getAllSprints(int page, int limit) {
        return sprintRepository.findAll();
    }
}
