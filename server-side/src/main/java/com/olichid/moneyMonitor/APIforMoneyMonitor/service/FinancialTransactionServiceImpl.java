package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.FinancialTransaction;
import com.olichid.moneyMonitor.APIforMoneyMonitor.repository.FinancialTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinancialTransactionServiceImpl implements FinancialTransactionService {

    @Autowired
    FinancialTransactionRepository financialTransactionRepository;

    @Override
    public List<FinancialTransaction> findAll() {
        return financialTransactionRepository.findAll();
    }

    @Override
    public List<FinancialTransaction> findByMonthAndYear(String month, int year) {
        return financialTransactionRepository.findByMonthAndYear(month, year);
    }

    @Override
    public void saveOrUpdateTransaction(FinancialTransaction financialTransaction) {
        financialTransactionRepository.save(financialTransaction);
    }

    @Override
    public void deleteTransaction(String id) {
        financialTransactionRepository.deleteById(id);
    }

    @Override
    public List<FinancialTransaction> findByYear(int year) {
        return financialTransactionRepository.findByYear(year);
    }

}
