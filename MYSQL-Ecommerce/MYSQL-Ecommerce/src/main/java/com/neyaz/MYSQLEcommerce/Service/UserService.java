package com.neyaz.MYSQLEcommerce.Service;

import com.neyaz.MYSQLEcommerce.Model.User;
import com.neyaz.MYSQLEcommerce.Repository.IuserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    IuserRepo iuserRepo;
    public void addUser(User user) {
        iuserRepo.save(user);
    }

    public User getuserById(Integer id) {
        return  iuserRepo.findUserById(id);
    }
}
