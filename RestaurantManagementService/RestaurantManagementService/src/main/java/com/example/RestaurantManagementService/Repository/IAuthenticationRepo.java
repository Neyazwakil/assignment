package com.example.RestaurantManagementService.Repository;


import com.example.RestaurantManagementService.Model.Admin;
import com.example.RestaurantManagementService.Model.AuthenticationToken;
import com.example.RestaurantManagementService.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByAdmin(Admin admin);
}
