package com.invictus.hrplatform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invictus.hrplatform.model.Departments;
import com.invictus.hrplatform.model.Employees;
import com.invictus.hrplatform.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employee) {
        return employeeService.createEmployee(employee);
    }
    
    
    @GetMapping("/employees")
    public ResponseEntity<List<Employees>> getEmployeesByDept(@RequestParam("dept") String dept)
    {
    	List<Employees> resp=new ArrayList<>();
    	resp=employeeService.getEmployeesByDepartment(dept);
    	return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    @GetMapping("/departments")
    public ResponseEntity<List<Departments>> getDepartments()
    {
    	List<Departments> resp=new ArrayList<>();
    	resp=employeeService.getAllDepartments();
    	return new ResponseEntity<>(resp,HttpStatus.OK);
    }
    
    
    @PutMapping("/employees")
    public ResponseEntity<Employees> updateEmployee( @RequestBody Employees updatedEmployee) {
        return new ResponseEntity<Employees>(employeeService.updateEmployee(updatedEmployee),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    
}