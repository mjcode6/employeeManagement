package com.mjCode.employeemanager;

import com.mjCode.employeemanager.model.Employee;
import com.mjCode.employeemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResouce {
private final EmployeeService employeeService;


    public EmployeeResouce(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
@GetMapping("/all")
public ResponseEntity<List<Employee>> getAllEmployee(){

  List<Employee> employees = employeeService.findAllEmployee();
  return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity <Employee> getEmployeeById(@PathVariable("id") Long id){
        Employee employee = employeeService.employeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity <Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity <Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("/find/{id}")
    public ResponseEntity <?> deleteEmployee(@PathVariable("id") Long id){
        Employee deleteEmployee = employeeService.deleteEmployee(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }



}
