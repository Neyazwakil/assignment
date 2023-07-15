package com.neyaz.MYSQLEcommerce.Repository;



import com.neyaz.MYSQLEcommerce.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IaddRepo extends JpaRepository<Address,Integer> {
}
