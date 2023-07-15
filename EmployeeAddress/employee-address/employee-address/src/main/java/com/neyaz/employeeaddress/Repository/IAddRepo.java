package com.neyaz.employeeaddress.Repository;
import com.neyaz.employeeaddress.Model.Address;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddRepo extends CrudRepository<Address,Long> {
}
