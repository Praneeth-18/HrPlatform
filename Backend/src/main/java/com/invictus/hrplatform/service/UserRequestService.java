package com.invictus.hrplatform.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invictus.hrplatform.model.DepartmentManager;
import com.invictus.hrplatform.model.Employees;
import com.invictus.hrplatform.model.UserRequest;
import com.invictus.hrplatform.payload.UserRequestPayload;
import com.invictus.hrplatform.repository.DepartmentManagerRepository;
import com.invictus.hrplatform.repository.EmployeeRepository;
import com.invictus.hrplatform.repository.UserRequestRepository;

@Service
public class UserRequestService {
	
	@Autowired
    private UserRequestRepository userRequestRepository;
	
	@Autowired
	private DepartmentManagerRepository departmentmanagerRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<UserRequest> getRequestsById(int id)
	{
		List<UserRequest> requests=new ArrayList<>();
		requests=userRequestRepository.findAllByAssignedTo(id).orElse(requests);
		return requests;
	}
	
	public UserRequest createRequests(UserRequestPayload request)
	{
		UserRequest resp=new UserRequest();
		resp.setRequestedType(request.getRequestedType());
		int id=departmentmanagerRepository.getManagerIdByUser(request.getCreatedBy());
		resp.setAssignedTo(id);
		resp.setCreatedBy(request.getCreatedBy());
		resp=userRequestRepository.save(resp);
		return resp;
	}
	
	public UserRequest updateRequest(UserRequestPayload request)
	{
		UserRequest resp=new UserRequest();
		resp=userRequestRepository.findById(request.getRequestId()).get();
		System.out.println(resp.toString());
		if(request.getStatus()=="Y")
		{	
		if(request.getRequestedType()=="Addition")
		{
//			if(resp.getAssignedTo()==1)
//			{
//				departmentmanagerRepository.getManagerIdByUser(id);
//			}
		}
		else
		{
			if(resp.getAssignedTo()!=1)
			{	
				resp.setAssignedTo(1);
				userRequestRepository.save(resp);
			}
			else
			{
				resp.setAssignedTo(1000);
				userRequestRepository.save(resp);
				Employees e=employeeRepository.findById(resp.getCreatedBy()).get();
				e.setSalary((int) Math.round(e.getSalary()*1.25));
			}
		}	
		}
		else
		{
			resp.setAssignedTo(1000);
			userRequestRepository.save(resp);
		}
		return resp;
	}

}
