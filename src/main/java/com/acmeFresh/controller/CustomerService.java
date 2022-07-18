package com.acmeFresh.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeFresh.entity.Orders;
import com.acmeFresh.entity.UserDetails;
import com.acmeFresh.globalExceptionHandler.AnyException;
import com.acmeFresh.service.AuthenticationImpl;
import com.acmeFresh.service.CustomerServiceImpl;

@RestController
public class CustomerService {
	
	@Autowired
	private CustomerServiceImpl customer;
	@Autowired
	private AuthenticationImpl auth;
	
	@GetMapping("/check")
	public String connectionChecking() {
		return "Welcome to our service";
	}
	@PostMapping("/signUp")
	public String ragister(@RequestBody UserDetails userdetails) {
		System.out.println(userdetails);

		return customer.userRagister(userdetails);
	}
	@PostMapping("/buyProduct")
	public Orders buyService(@RequestParam("key") String key, @RequestBody List<Integer> id) throws AnyException {
		UserDetails userD=auth.validateKey(key);
		
		return customer.buyItem(id,userD);
	}
	
	
}
