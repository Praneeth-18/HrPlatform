package com.invictus.hrplatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invictus.hrplatform.model.Employees;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {
	
	Optional<Employees> findByEmail(String email);
	
	@Query(value="Select e.* from employees e join dept_emp d on (e.emp_no=d.emp_no) where d.dept_no=:dept",nativeQuery = true)
	Optional<List<Employees>> findByDept(@Param("dept")String dept);
}