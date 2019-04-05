package com.olichid.moneyMonitor.APIforMoneyMonitor.repository;

import com.olichid.moneyMonitor.APIforMoneyMonitor.defaultDoc.EachCost;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CostRepository extends MongoRepository<EachCost, String> {

    List<EachCost> findByMonthAndYear(String month, int year);

    List<EachCost> findByYear(int year);
}
