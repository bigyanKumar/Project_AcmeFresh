package com.acmeFresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
