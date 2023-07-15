package com.neyaz.MYSQLEcommerce.Controller;


import com.neyaz.MYSQLEcommerce.Model.User;
import com.neyaz.MYSQLEcommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public void adduser(@RequestBody User user){
        userService.addUser(user);
    }
    @GetMapping("user/{id}")
    public User getuser(@PathVariable Integer id){return userService.getuserById(id);}
}
