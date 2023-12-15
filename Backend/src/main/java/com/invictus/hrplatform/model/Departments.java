package com.invictus.hrplatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="departments")
@Data
public class Departments {

	@Id
	@Column(name = "dept_no")
	private String id;
	
	@Column(name="dept_name")
	private String deptName; 
	
}
