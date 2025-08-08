package com.kata.trello_fake_kata.infraestructure.controller;
import com.kata.trello_fake_kata.domain.dto.CreateUserDTO;
import com.kata.trello_fake_kata.domain.dto.PagedResponse;
import com.kata.trello_fake_kata.domain.model.User;
import com.kata.trello_fake_kata.domain.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/v1/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public PagedResponse<User> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int limit) {
        return userService.getAllUsers(page, limit);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/searchByEmail")
    public Optional<User> getUserByEmail(@RequestParam(required = true) String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody CreateUserDTO user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @GetMapping("/search")
    public PagedResponse<User> searchUsersByFilters(@RequestParam(required = false) String name_like,
                                           @RequestParam(required = false) String email,
                                           @RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "50") int limit) {

        return userService.searchUsersByFilters(name_like, email, page, limit);
    }


}
