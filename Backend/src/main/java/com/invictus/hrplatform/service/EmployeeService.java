package com.invictus.hrplatform.service;

import java.util.List;

import com.invictus.hrplatform.model.Departments;
import com.invictus.hrplatform.model.Employees;

public interface EmployeeService {

	List<Employees> getAllEmployees();
    Employees getEmployeeByEmail(String id);
    Employees createEmployee(Employees employee);
    Employees updateEmployee(Employees updatedEmployee);
    void deleteEmployee(Long id);
    List<Employees> getEmployeesByDepartment(String dept);
    List<Departments> getAllDepartments();
}
