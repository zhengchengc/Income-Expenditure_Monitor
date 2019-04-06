package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.Expense;

public interface ExpenseService {

    List<Expense> findAll();

    List<Expense> findByMonthAndYear(String month, int year);

    List<Expense> findByYear(int year);

    void saveOrUpdateTransaction(Expense expense);

    void deleteTransaction(String id);

}
