package com.invictus.hrplatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invictus.hrplatform.model.UserRequest;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Integer> {
	
	Optional<List<UserRequest>> findAllByAssignedTo(int id);
    
}
