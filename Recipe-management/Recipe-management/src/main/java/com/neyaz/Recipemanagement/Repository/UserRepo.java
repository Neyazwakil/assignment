package com.neyaz.Recipemanagement.Repository;

import com.neyaz.Recipemanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findFirstByUserEmail(String newEmail);
}
