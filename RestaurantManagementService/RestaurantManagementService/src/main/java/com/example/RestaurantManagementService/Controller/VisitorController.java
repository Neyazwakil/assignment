package com.example.RestaurantManagementService.Controller;


import com.example.RestaurantManagementService.Model.FoodItem;
import com.example.RestaurantManagementService.Service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Validated
@RestController
public class VisitorController {
    @Autowired
    FoodItemService Foodservice;
    @GetMapping()
    public List<FoodItem> getall(){
     return Foodservice.getall();
    }
}
