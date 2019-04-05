package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import com.olichid.moneyMonitor.APIforMoneyMonitor.defaultDoc.EachCost;
import com.olichid.moneyMonitor.APIforMoneyMonitor.repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements CostService {

    @Autowired
    CostRepository costRepository;

    @Override
    public List<EachCost> findAll() {
        return costRepository.findAll();
    }

    @Override
    public List<EachCost> findByMonthAndYear(String month, int year) {
        return costRepository.findByMonthAndYear(month, year);
    }

    @Override
    public List<EachCost> findByYear(int year) {
        return costRepository.findByYear(year);
    }

    @Override
    public void saveOrUpdateEntry(EachCost eachCost) {
        costRepository.save(eachCost);
    }

    @Override
    public void deleteEntry(String id) {
        costRepository.deleteById(id);
    }
}
