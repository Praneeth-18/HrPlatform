package com.invictus.hrportal.service;

import com.invictus.hrportal.model.User;

public interface KeycloakService {
	
	public void registerUser(User user);
	public String loginUser(String username, String password);
	public void logoutUser(String username);
}
