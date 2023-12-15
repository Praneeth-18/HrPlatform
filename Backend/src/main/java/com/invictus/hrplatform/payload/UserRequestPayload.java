package com.invictus.hrplatform.payload;

import lombok.Data;

@Data
public class UserRequestPayload {

	private int createdBy;
	
	private int assignedTo;
	
	private String requestedType;
	
	private int requestId;
	
	private String status;
}
