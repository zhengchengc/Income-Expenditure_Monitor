package com.olichid.moneyMonitor.APIforMoneyMonitor.controller;

import com.olichid.moneyMonitor.APIforMoneyMonitor.defaultDoc.EachCost;
import com.olichid.moneyMonitor.APIforMoneyMonitor.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/cost")
public class CostController {

    @Autowired
    CostService costService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<EachCost> result = costService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<?> getByYearAndOrMonth(@PathVariable("year") Integer year, @PathVariable("month") String month) {
        List<EachCost> result = new ArrayList<>();
        if ("All".equals(month)) {
            result = costService.findByYear(year);
        } else {
            result = costService.findByMonthAndYear(month, year);
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveOrUpdateEntry(@RequestBody EachCost eachCost) {
        costService.saveOrUpdateEntry(eachCost);
        return new ResponseEntity("save successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteEntry(@RequestParam("id") String id) {
        costService.deleteEntry(id);
    }
}
