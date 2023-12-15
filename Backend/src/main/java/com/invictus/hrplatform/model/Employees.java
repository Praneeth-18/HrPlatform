package com.invictus.hrplatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="employees")
@Data
public class Employees {
	
	@Id
	@Column(name="emp_no")
	private int empNumber;
	
	@Column(name="birth_date")
	private String birthDate;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
    
	@Column(name="hire_date")
	private String hireDate;
	
	@Column(name="role")
	private String role;
	
	@Column(name="email_id")
	private String email;
    
	@Column(name="salary") 
	private int salary;
}
