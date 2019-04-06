package com.olichid.moneyMonitor.APIforMoneyMonitor.controller;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.Expense;
import com.olichid.moneyMonitor.APIforMoneyMonitor.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    ExpenseService expenseService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Expense> result = expenseService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
        List<Expense> result;
        if("All".equals(month)) {
            result = expenseService.findByYear(year);
        } else {
            result = expenseService.findByMonthAndYear(month, year);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrUpdateTransaction(@RequestBody Expense expense) {
        expenseService.saveOrUpdateTransaction(expense);
        return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam("id") String id) {
        expenseService.deleteTransaction(id);
    }


}
