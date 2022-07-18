package com.acmeFresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeFresh.DTO.LoginDTO;
import com.acmeFresh.entity.LoginSession;
import com.acmeFresh.globalExceptionHandler.AnyException;
import com.acmeFresh.service.AuthenticationImpl;

@RestController
public class Authentication {
	@Autowired
	private AuthenticationImpl auth;
	
	@PostMapping("/userAuth")
	public LoginSession login(@RequestBody LoginDTO login) throws AnyException {
		
		return auth.login(login);
	}
	
	@GetMapping("/logOut")
	public String signUp(@RequestParam("key") String key) {
		return auth.logOut(key);
	}
}
