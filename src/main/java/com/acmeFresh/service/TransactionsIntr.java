package com.acmeFresh.service;

import com.acmeFresh.entity.Transactions;
import com.acmeFresh.globalExceptionHandler.AnyException;

public interface TransactionsIntr {
	
	public Transactions getTransaction(Double amount,String id)throws AnyException;

}
