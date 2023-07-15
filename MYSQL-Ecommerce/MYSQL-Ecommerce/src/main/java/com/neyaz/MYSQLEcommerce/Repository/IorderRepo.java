package com.neyaz.MYSQLEcommerce.Repository;


import com.neyaz.MYSQLEcommerce.Model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IorderRepo extends JpaRepository<OrderEntity,Integer>{
}
