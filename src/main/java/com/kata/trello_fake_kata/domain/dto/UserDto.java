package com.kata.trello_fake_kata.domain.dto;

import com.kata.trello_fake_kata.domain.model.User;

public class UserDto {
    private String _id;
    private String name;
    private String email;

    public UserDto(User user) {
        this._id = user.get_id();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    // Getters
    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
