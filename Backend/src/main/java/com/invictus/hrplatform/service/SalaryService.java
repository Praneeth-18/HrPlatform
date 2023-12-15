package com.invictus.hrplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invictus.hrplatform.model.Salary;
import com.invictus.hrplatform.payload.DepartmentSalary;
import com.invictus.hrplatform.repository.SalaryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SalaryService {


    @Autowired
    private SalaryRepository salaryRepository;

    public List<Salary> findAllSalariesByEmp(int emp) {
        return salaryRepository.findAllByEmpNumber(emp);
    }
    
    public List<DepartmentSalary> findAllSalariesByDepartment(String dept) {
        return salaryRepository.findAllByDepartment(dept);
    }
    
    
    
    
    
}
