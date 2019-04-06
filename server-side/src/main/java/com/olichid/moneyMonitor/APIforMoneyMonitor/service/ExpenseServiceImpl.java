package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.Expense;
import com.olichid.moneyMonitor.APIforMoneyMonitor.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    @Override
    public List<Expense> findByMonthAndYear(String month, int year) {
        return expenseRepository.findByMonthAndYear(month, year);
    }

    @Override
    public void saveOrUpdateTransaction(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public void deleteTransaction(String id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> findByYear(int year) {
        return expenseRepository.findByYear(year);
    }

}
