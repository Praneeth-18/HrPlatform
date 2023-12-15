package com.invictus.hrplatform.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invictus.hrplatform.model.Salary;
import com.invictus.hrplatform.payload.DepartmentSalary;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Integer> {
    
	
	@Query(value = "Select s.* from salaries s where s.emp_no=:empNum",nativeQuery = true)
	List<Salary> findAllByEmpNumber(@Param("empNum")int emp);
	
	@Query(value = "SELECT sum(s.salary) as salary,s.from_date as fromDate FROM employees.salaries s join employees.dept_emp d on (d.emp_no=s.emp_no) where d.dept_no=:deptNo group by s.from_date",nativeQuery = true)
	List<DepartmentSalary> findAllByDepartment(@Param("deptNo")String empNum); 
}
