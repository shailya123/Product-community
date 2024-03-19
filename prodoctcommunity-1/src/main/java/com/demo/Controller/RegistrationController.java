package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.AdminDetails;
import com.demo.model.UserRegistration;
import com.demo.service.AdminLoginService;
import com.demo.service.RegistrationService;
import com.demo.service.SaveDataService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {
	@Autowired
	private RegistrationService service;
	@Autowired
	private SaveDataService read;
	@Autowired
	private AdminLoginService adminService;

	@PostMapping("/registeruser")
	public UserRegistration RegisterUser(@RequestBody UserRegistration user) throws Exception {
		String emailId = user.getEmailId();
		if (emailId != null && !"".equals(emailId)) {
			UserRegistration userObj = service.fetchByEmail(emailId);
			if (userObj != null)
				throw new Exception("Email id already Exist,try with another emailId");
		}
		return service.saveUser(user);
	}

	@PostMapping("/loginuser")
	public UserRegistration loginUserUser(@RequestBody UserRegistration user) throws Exception {
		read.csvReader();
		String emailId = user.getEmailId();
		String password = user.getPassword();
		UserRegistration userObj = null;
		if (emailId != null && password != null) {
			userObj = service.fetchByEmailAndPassword(emailId, password);
			if (userObj == null)
				throw new Exception("Bad credentials");
		}
		return userObj;
	}

	@GetMapping("/user")
	public List<UserRegistration> getUser() {
		return service.findAllUser();
	}
	@PostMapping("/loginadmin")
	public AdminDetails loginAdmin(@RequestBody AdminDetails admin) throws Exception {
		
		String email = admin.getEmail();
		String password = admin.getPassword();
	    AdminDetails userObj = null;
		if (email!= null && password != null) {
			userObj = adminService.fetchByEmailAndPassword(email, password);
			if (userObj == null)
				throw new Exception("Bad credentials");
		}
		return userObj;
	}

}
