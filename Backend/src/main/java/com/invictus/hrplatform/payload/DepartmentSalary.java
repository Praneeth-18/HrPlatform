package com.invictus.hrplatform.payload;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;


public interface DepartmentSalary {
	

    Date getFromDate();

    int getSalary();

}
