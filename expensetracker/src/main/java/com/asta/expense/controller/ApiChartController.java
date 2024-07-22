package com.asta.expense.controller;

import com.asta.expense.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Map;

@RestController
@RequestMapping("/api/chart")
public class ApiChartController {

    @Autowired
    ReportService reportService;

    @GetMapping("/monthly-data")
    public Map<Month, BigDecimal[]> getMonthlyData() {
        return reportService.getMonthlyData();
    }
}
