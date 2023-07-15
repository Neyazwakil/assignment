package com.neyaz.MYSQLEcommerce.Service;



import com.neyaz.MYSQLEcommerce.Model.OrderEntity;

import com.neyaz.MYSQLEcommerce.Repository.IorderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    IorderRepo iorderRepo;
    public void addOrder(OrderEntity orderEntity) {
        iorderRepo.save(orderEntity);
    }

    public Optional<OrderEntity> getorderbyid(Integer id) {
        return iorderRepo.findById(id);
    }
}
