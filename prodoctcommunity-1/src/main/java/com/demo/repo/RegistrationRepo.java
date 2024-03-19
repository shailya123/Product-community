package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.UserRegistration;

@Repository
public interface RegistrationRepo extends JpaRepository<UserRegistration, Integer> {
	public UserRegistration findByEmailId(String email);

	public UserRegistration findByEmailIdAndPassword(String email, String password);
}
