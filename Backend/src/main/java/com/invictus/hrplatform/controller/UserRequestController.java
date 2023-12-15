package com.invictus.hrplatform.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.invictus.hrplatform.model.UserRequest;
import com.invictus.hrplatform.payload.UserRequestPayload;
import com.invictus.hrplatform.service.UserRequestService;

@RestController
@RequestMapping("/api")
public class UserRequestController {
	
	@Autowired
    private UserRequestService userRequestService;
    
    
    @GetMapping("/request")
    public ResponseEntity<List<UserRequest>> getAllUserRequestsById(@RequestParam("id") int id) {
    	List<UserRequest> requests=new ArrayList<>();
    	requests= userRequestService.getRequestsById(id);
    	return new ResponseEntity<>(requests,HttpStatus.OK);
    }

    
    @PostMapping("/request/create")
    public ResponseEntity<UserRequest> createUserRequest(@RequestBody UserRequestPayload payload )
    {
    	System.out.println(payload.toString());
    	return new ResponseEntity<>(userRequestService.createRequests(payload),HttpStatus.OK);
    }
    
    @PutMapping("/request/update")
    public ResponseEntity<UserRequest> updateUserRequest(@RequestBody UserRequestPayload payload )
    {
    	System.out.println(payload.toString());
    	return new ResponseEntity<>(userRequestService.updateRequest(payload),HttpStatus.OK);
    }
    // You can add more controller methods for handling other operations
}