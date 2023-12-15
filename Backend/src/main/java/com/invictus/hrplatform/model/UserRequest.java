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
@Table(name="user_request")
@Data
public class UserRequest {

	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="request_type")
	private String requestedType;
	
	@Column(name="assigned_to")
	private int assignedTo;
	
	@Column(name="created_by")
	private int createdBy;
	
}
