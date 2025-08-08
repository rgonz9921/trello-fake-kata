package com.kata.trello_fake_kata.infraestructure.persistence;

import com.kata.trello_fake_kata.domain.model.Sprint;
import com.kata.trello_fake_kata.domain.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepository extends MongoRepository<Sprint, String> {
    Page<Sprint> findAll(Pageable pageable);
}
