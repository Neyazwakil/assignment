package com.Neyaz.InstaBackend.repository;

import com.Neyaz.InstaBackend.model.AuthenticationToken;
import com.Neyaz.InstaBackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
