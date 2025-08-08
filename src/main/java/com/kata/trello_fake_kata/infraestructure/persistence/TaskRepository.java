package com.kata.trello_fake_kata.infraestructure.persistence;

import com.kata.trello_fake_kata.domain.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TaskRepository extends MongoRepository<Task, String> {
    Page<Task> findAll(Pageable pageable);

    @Query("{ 'sprint': { $regex: ?0, $options: 'i' } }")
    Optional<Task> findBySprint(String idSprint);
}
