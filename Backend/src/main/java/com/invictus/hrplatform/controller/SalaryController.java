package com.invictus.hrplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invictus.hrplatform.model.Salary;
import com.invictus.hrplatform.payload.DepartmentSalary;
import com.invictus.hrplatform.service.SalaryService;

import java.util.List;

@RestController
@RequestMapping("/api/salaries")
public class SalaryController {
	
	@Autowired
    private SalaryService salaryService;
	
    
    @GetMapping("/department")
    public ResponseEntity<List<DepartmentSalary>> getSalariesByDepartment(@RequestParam("dept") String department)
    {
    	
    	return new ResponseEntity<>(salaryService.findAllSalariesByDepartment(department),HttpStatus.OK);
    }
    
    @GetMapping("/emp")
    public ResponseEntity<List<Salary>> getSalariesByEmployee(@RequestParam("emp") int emp)
    {
    	
    	return new ResponseEntity<>(salaryService.findAllSalariesByEmp(emp),HttpStatus.OK);
    }

    // Other endpoints for custom queries
}
