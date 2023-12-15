package com.invictus.hrplatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invictus.hrplatform.model.DepartmentEmployee;

@Repository
public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, String> {
    // You can add custom queries or methods if needed
}
