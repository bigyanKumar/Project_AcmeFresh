package com.acmeFresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.UserDetails;

public interface UserDetailsDao extends JpaRepository<UserDetails, String> {
	
	
	UserDetails findByPassword(String pass);

}
