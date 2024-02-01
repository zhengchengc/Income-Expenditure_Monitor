package com.yimotec.expensemanager.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yimotec.expensemanager.domain.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{

	List<Expense> findByMonthAndYear(String month, int year);
	
	List<Expense> findByYear(int year);

}
