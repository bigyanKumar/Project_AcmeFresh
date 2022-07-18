package com.acmeFresh.service;

import java.util.List;

import com.acmeFresh.entity.Orders;
import com.acmeFresh.entity.UserDetails;
import com.acmeFresh.globalExceptionHandler.AnyException;

public interface CustomerServiceIntr {
	
	public String userRagister(UserDetails user);
	
	public Orders buyItem(List<Integer> id, UserDetails userD) throws AnyException;
	

}
