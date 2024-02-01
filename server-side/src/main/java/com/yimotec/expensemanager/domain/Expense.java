package com.yimotec.expensemanager.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document
public class Expense {

	@Id
	String id;
	String description;
	Integer amount;
	String month;
	int year;

}
