package com.kata.trello_fake_kata.domain.service;
import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.dto.UserDto;
import com.kata.trello_fake_kata.domain.model.User;

import java.util.Optional;

public interface IUserService {
    PagedResponse<User> getAllUsers(int page, int limit);

    Optional<User> getUserById(String id);

    Optional<User> getUserByEmail(String email);

    User createUser(User user);

    User updateUser(String id, User updateUser);

    PagedResponse<User>  searchUsersByFilters(String name, String email, int page, int limit);
}
