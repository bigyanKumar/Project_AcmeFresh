package com.acmeFresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
