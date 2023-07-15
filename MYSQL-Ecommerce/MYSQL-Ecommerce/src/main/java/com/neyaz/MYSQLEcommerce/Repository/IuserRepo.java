package com.neyaz.MYSQLEcommerce.Repository;


import com.neyaz.MYSQLEcommerce.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepo extends JpaRepository<User,Integer>{


    User findUserById(Integer id);
}
