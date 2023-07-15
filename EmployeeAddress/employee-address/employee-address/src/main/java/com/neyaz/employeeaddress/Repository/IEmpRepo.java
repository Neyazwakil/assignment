package com.neyaz.employeeaddress.Repository;
import com.neyaz.employeeaddress.Model.Employee;

import org.springframework.data.repository.CrudRepository;



public interface IEmpRepo extends CrudRepository<Employee,Long> {
}