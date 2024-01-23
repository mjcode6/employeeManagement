package com.mjCode.employeemanager.service;

import com.mjCode.employeemanager.Repo.EmployeeRepo;
import com.mjCode.employeemanager.exception.UserNotFoundException;
import com.mjCode.employeemanager.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
           employee.setEmployeeCode(UUID.randomUUID().toString());
           return  employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);
    }


    public Employee employeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("user by id " + id + "was not found"));
    }
    public Employee deleteEmployee(Long id){
        return employeeRepo.deleteEmployeeById(id);
    }



}
