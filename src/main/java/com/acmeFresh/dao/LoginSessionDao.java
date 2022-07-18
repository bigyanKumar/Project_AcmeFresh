package com.acmeFresh.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.LoginSession;

public interface LoginSessionDao extends JpaRepository<LoginSession, String> {
	
	LoginSession findByAutoGenId(String key);

}
