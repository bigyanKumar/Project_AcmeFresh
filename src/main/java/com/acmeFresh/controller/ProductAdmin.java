package com.acmeFresh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.acmeFresh.entity.Product;
import com.acmeFresh.service.ProductAdminImpl;

@RestController
public class ProductAdmin {
	@Autowired
	private ProductAdminImpl productImpl;
	@PostMapping("addProduct")
	public String addProduct(@RequestBody Product product) {
		
		return productImpl.addItem(product);
		
	}

}
