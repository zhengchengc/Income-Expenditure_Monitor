package com.olichid.moneyMonitor.APIforMoneyMonitor.controller;

import java.util.List;

import com.olichid.moneyMonitor.APIforMoneyMonitor.domain.FinancialTransaction;
import com.olichid.moneyMonitor.APIforMoneyMonitor.service.FinancialTransactionService;
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
@RequestMapping("/financialtransaction")
public class FinancialTransactionController {

    @Autowired
    FinancialTransactionService financialTransactionService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<FinancialTransaction> result = financialTransactionService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month) {
        List<FinancialTransaction> result;
        if("All".equals(month)) {
            result = financialTransactionService.findByYear(year);
        } else {
            result = financialTransactionService.findByMonthAndYear(month, year);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addOrUpdateTransaction(@RequestBody FinancialTransaction financialTransaction) {
        financialTransactionService.saveOrUpdateTransaction(financialTransaction);
        return new ResponseEntity("Expense added succcessfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteTransaction(@RequestParam("id") String id) {
        financialTransactionService.deleteTransaction(id);
    }


}
