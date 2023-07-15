package com.neyaz.employeeaddress.Service;
import com.neyaz.employeeaddress.Model.Employee;
import com.neyaz.employeeaddress.Repository.IEmpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmpRepo iEmpRepo;
    public List<Employee> findAll() {
        return (List<Employee>) iEmpRepo.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return iEmpRepo.findById(id);
    }

    public String save(Employee employee) {
        iEmpRepo.save(employee);
        return "save success";
    }

    public String updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = iEmpRepo.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setEmpName(employee.getEmpName());
            existingEmployee.setAddress(employee.getAddress());
            iEmpRepo.save(existingEmployee);
            return "Employee updated successfully";
        }
        return "Employee not found";
    }


    public String deleteById(Long id) {
        iEmpRepo.deleteById(id);
        return"delete success";
    }

}
