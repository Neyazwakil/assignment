package com.neyaz.UserManagement.controller;

import com.neyaz.UserManagement.model.User;
import com.neyaz.UserManagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class UserController {
    @Autowired
    UserService userservice;
    @PostMapping("users")
    public String addUsers(@RequestBody List<User> users)
    {
        return userservice.addUsers(users);
    }

    @GetMapping("users/byid/{Id}")
    public User getUserId(@PathVariable Integer Id)
    {
        return userservice.getAllUsersbyId(Id);
    }

    @GetMapping("users")
    public List<User> getUsers()
    {
        return userservice.getusers();
    }

    @PutMapping("users/userid/{Id}")
    public String updateUserbyId(@PathVariable Integer Id,@RequestBody User users)
    {
        return userservice.updateUserById(Id,users);
    }
    @DeleteMapping("users/{Id}")
    public String removeUser(@PathVariable Integer Id)
    {
        return userservice.removeUser(Id);
    }

}
