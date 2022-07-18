package com.acmeFresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.Orders;

public interface OrdersDao extends JpaRepository<Orders, Integer>{

}
