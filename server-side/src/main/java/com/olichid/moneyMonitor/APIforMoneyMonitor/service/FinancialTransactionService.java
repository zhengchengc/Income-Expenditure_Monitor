package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.FinancialTransaction;

public interface FinancialTransactionService {

    List<FinancialTransaction> findAll();

    List<FinancialTransaction> findByMonthAndYear(String month, int year);

    List<FinancialTransaction> findByYear(int year);

    void saveOrUpdateTransaction(FinancialTransaction financialTransaction);

    void deleteTransaction(String id);

}
