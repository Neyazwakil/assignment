package com.neyaz.User.management.System.Service;



import com.neyaz.User.management.System.Model.User;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public User addUser(User user) {
        user.setUserId((long) (users.size() + 1));
        users.add(user);
        return user;
    }

    public User getUserById(Long userId) {
        return users.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElse(null);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User updateUserInfo(User user) {
        User existingUser = users.stream()
                .filter(u -> u.getUserId().equals(user.getUserId()))
                .findFirst()
                .orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setDateOfBirth(user.getDateOfBirth());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
        }
        return existingUser;
    }

    public boolean deleteUser(Long userId)
    {
        return users.removeIf(u -> u.getUserId().equals(userId));
    }
}
