package com.kata.trello_fake_kata.infraestructure.persistence;
import com.kata.trello_fake_kata.domain.model.Sessions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SessionRepository extends MongoRepository<Sessions, String> {
    Optional<Sessions> findByUserEmail(String userEmail);
}
