package com.olichid.moneyMonitor.APIforMoneyMonitor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.FinancialTransaction;

public interface FinancialTransactionRepository extends MongoRepository<FinancialTransaction, String>{

    List<FinancialTransaction> findByMonthAndYear(String month, int year);

    List<FinancialTransaction> findByYear(int year);

}
