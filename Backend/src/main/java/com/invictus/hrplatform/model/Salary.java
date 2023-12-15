package com.invictus.hrplatform.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "salaries")
@Data
public class Salary {

	@Id
	@Column(name="id")
	private int id;
	
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "from_date")
    @Temporal(TemporalType.DATE)
    private Date fromDate;

    @Column(name = "salary")
    private int salary;

    @Column(name = "to_date")
    @Temporal(TemporalType.DATE)
    private Date toDate;


	
    
}
