package com.acmeFresh.service;

import com.acmeFresh.DTO.LoginDTO;
import com.acmeFresh.entity.LoginSession;
import com.acmeFresh.entity.UserDetails;
import com.acmeFresh.globalExceptionHandler.AnyException;

public interface AuthenticationIntr {
	
	public LoginSession login(LoginDTO login)throws AnyException;
	public String logOut(String key);
	public UserDetails validateKey(String key)throws AnyException;

}
