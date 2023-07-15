package com.neyaz.MYSQLEcommerce.Controller;


import com.neyaz.MYSQLEcommerce.Model.OrderEntity;

import com.neyaz.MYSQLEcommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("order")
    public void addOrder (@RequestBody OrderEntity orderEntity){orderService.addOrder(orderEntity);}

    @GetMapping("order/{Id}")
    public Optional<OrderEntity> getorder(@PathVariable Integer Id){ return orderService.getorderbyid(Id);}
}
