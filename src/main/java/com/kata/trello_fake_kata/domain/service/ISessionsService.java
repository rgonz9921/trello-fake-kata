package com.kata.trello_fake_kata.domain.service;
import com.kata.trello_fake_kata.domain.model.Sessions;

import java.util.Optional;

public interface ISessionsService {

    Sessions refresh(Sessions sessionService);

    Optional<Sessions> findByEmail(String jwt);
}
