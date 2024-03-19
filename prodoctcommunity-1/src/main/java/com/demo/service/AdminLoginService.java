package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.AdminDetails;
import com.demo.repo.AdminDetailRepo;

@Service
public class AdminLoginService {

	@Autowired
	private AdminDetailRepo repo;
	public AdminDetails fetchByEmailAndPassword(String email, String password) {
		return repo.findByEmailAndPassword(email, password);
	}
}
