package com.example.InstaBasic.Service;

import com.example.InstaBasic.Model.User;

import com.example.InstaBasic.Model.AuthenticationToken;
import com.example.InstaBasic.Repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Autowired
    ITokenRepo tokenRepo;
    public void saveToken(AuthenticationToken token) {
        tokenRepo.save(token);
    }

    public boolean authenticate(String email, String token) {

        if(token==null && email==null){
            return false;
        }

        AuthenticationToken authToken = tokenRepo.findFirstByToken(token);

        if(authToken==null){
            return false;
        }

        String expectedEmail = authToken.getUser().getEmail();


        return expectedEmail.equals(email);
    }

    public User findUserByToken(String token) {
        return tokenRepo.findFirstByToken(token).getUser();
    }
}
