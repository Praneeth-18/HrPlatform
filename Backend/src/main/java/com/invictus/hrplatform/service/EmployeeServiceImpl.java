package com.invictus.hrplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invictus.hrplatform.model.Departments;
import com.invictus.hrplatform.model.Employees;
import com.invictus.hrplatform.repository.DepartmentsRepository;
import com.invictus.hrplatform.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentsRepository departmentRepo;

	@Override
	public List<Employees> getAllEmployees() {
		
		return null;
	}

	@Override
	public Employees getEmployeeByEmail(String id) {
		Employees emp=new Employees();
		emp=employeeRepository.findByEmail(id).orElse(emp);
		return emp;
	}

	@Override
	public Employees createEmployee(Employees employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees updateEmployee(Employees updatedEmployee) {
		employeeRepository.save(updatedEmployee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employees> getEmployeesByDepartment(String dept) {
		List<Employees> resp=new ArrayList<>();
		resp=employeeRepository.findByDept(dept).get();
		return resp;
	}

	@Override
	public List<Departments> getAllDepartments() {
		List<Departments> resp=new ArrayList<>();
		resp=departmentRepo.findAll();
		return resp;
	}
    

}