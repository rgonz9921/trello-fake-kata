package com.kata.trello_fake_kata.domain.service;
import com.kata.trello_fake_kata.domain.model.Sprint;

import java.util.List;

public interface ISprintService {
    List<Sprint> getAllSprints(int page, int limit);
}
