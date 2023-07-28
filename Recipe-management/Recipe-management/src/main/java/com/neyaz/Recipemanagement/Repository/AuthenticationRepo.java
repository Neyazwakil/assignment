package com.neyaz.Recipemanagement.Repository;

import com.neyaz.Recipemanagement.Model.AuthenticationToken;
import com.neyaz.Recipemanagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthenticationRepo extends JpaRepository<AuthenticationToken ,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
