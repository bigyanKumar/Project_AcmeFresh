package com.acmeFresh.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.acmeFresh.entity.Transactions;

public interface TransactionDao extends JpaRepository<Transactions, String> {

}
