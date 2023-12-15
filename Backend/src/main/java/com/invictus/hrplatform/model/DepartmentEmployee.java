package com.invictus.hrplatform.model;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.IdGeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="dept_emp")
@Data
public class DepartmentEmployee {

	@Id
	@Column(name="emp_no")
	private String employeeNumber; 
	
	@Column(name = "dept_no")
	private String departmentNumber;
	
	@Column(name="from_date")
	private String fromDate;
	
	@Column(name="to_date")
	private String toDate;
	
	
	
}
