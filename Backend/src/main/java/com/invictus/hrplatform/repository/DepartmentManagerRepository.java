package com.invictus.hrplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.invictus.hrplatform.model.DepartmentManager;

@Repository
public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, Integer> {
    // You can add custom queries or methods if needed
	@Query(value="Select d.emp_no from dept_manager d join dept_emp de on (d.dept_no=de.dept_no) where de.emp_no=:id",nativeQuery = true)
	int getManagerIdByUser(@Param("id") int id);
	
	
}
