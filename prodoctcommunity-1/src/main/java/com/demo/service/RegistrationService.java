package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.UserRegistration;
import com.demo.repo.RegistrationRepo;

@Service
public class RegistrationService {
	@Autowired
	RegistrationRepo repo;

	public UserRegistration saveUser(UserRegistration user) {
		return repo.save(user);
	}

	public UserRegistration fetchByEmail(String email) {
		return repo.findByEmailId(email);
	}

	public UserRegistration fetchByEmailAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);
	}

	public List<UserRegistration> findAllUser() {
		return repo.findAll();
	}
}
