package com.acmeFresh.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmeFresh.dao.TransactionDao;
import com.acmeFresh.entity.Transactions;
import com.acmeFresh.globalExceptionHandler.AnyException;

@Service
public class TransactionImpl implements TransactionsIntr{
	
	@Autowired
	private TransactionDao transS;
	

	@Override
	public Transactions getTransaction(Double amount, String id) throws AnyException {
		return transS.save(new Transactions(id,true,LocalDateTime.now(),amount));
	}

}
