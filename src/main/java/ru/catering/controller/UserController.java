package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.User;
import ru.catering.service.UserService;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public Long createUser(@RequestBody User userFromAdmin) {
        return userService.createUser(userFromAdmin);
    }

    @GetMapping(value = "/user")
    public User getUserById(@RequestParam Long id) {
        return userService.getUser(id);
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}