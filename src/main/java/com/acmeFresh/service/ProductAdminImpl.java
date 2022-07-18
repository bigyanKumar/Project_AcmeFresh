package com.acmeFresh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeFresh.dao.ProductDao;
import com.acmeFresh.entity.Product;

@Service
public class ProductAdminImpl implements ProductAdminIntr {
	@Autowired
	private ProductDao productD;
	@Override
	public String addItem(Product product){
		productD.save(product);
		return "Product added sucessfully";
	}
	
}
