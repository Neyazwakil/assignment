package com.neyaz.User.management.System.Controller;

import com.neyaz.User.management.System.Model.User;
import com.neyaz.User.management.System.Service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getUser/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return null;
        }
        return user;
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUserInfo")
    public User updateUserInfo(@Valid @RequestBody User user) {
        User updatedUser = userService.updateUserInfo(user);
        if (updatedUser == null) {
            return null;
        }
        return updatedUser;
    }

    @DeleteMapping("/deleteUser/{userId}")
    public boolean deleteUser(@PathVariable("userId") Long userId) {
        return userService.deleteUser(userId);
    }
}