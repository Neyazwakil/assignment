package com.example.RestaurantManagementService.Repository;


import com.example.RestaurantManagementService.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IFoodRepo extends JpaRepository<FoodItem,Long> {

}
