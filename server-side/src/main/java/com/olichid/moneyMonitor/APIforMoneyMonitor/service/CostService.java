package com.olichid.moneyMonitor.APIforMoneyMonitor.service;

import com.olichid.moneyMonitor.APIforMoneyMonitor.defaultDoc.EachCost;

import java.util.List;

public interface CostService {

    List<EachCost> findAll();

    List<EachCost> findByMonthAndYear(String month, int year);

    List<EachCost> findByYear(int year);

    void saveOrUpdateEntry(EachCost eachCost);

    void deleteEntry(String id);
}
