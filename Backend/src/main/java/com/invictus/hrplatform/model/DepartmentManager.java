package com.invictus.hrplatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="dept_manager")
@Data
public class DepartmentManager {

	
	@Id
	@Column(name="emp_no")
	private int employeeNumber;
	
	@Column(name="dept_no")
	private String departmentNumber;
	
}
