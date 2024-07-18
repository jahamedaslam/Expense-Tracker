package com.asta.expense.controller;

import com.asta.expense.payload.dao.DailyReport;
import com.asta.expense.service.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    private static final String REPORT = "admin/report";

    @GetMapping("/report")
    public String getDailyReport(ModelMap model,
                                 @RequestParam String fromDate,
                                 @RequestParam String toDate,
                                 @RequestParam(required = false, defaultValue = "1") int type) {
        LocalDate fromDatee;
        LocalDate toDatee;
        if (fromDate == null || fromDate.equals("")) {
            fromDatee = LocalDate.now().minusDays(7);
        }
        else {
            fromDatee = LocalDate.parse(fromDate);
        }
        if (toDate == null|| toDate.equals("")) {
            toDatee = LocalDate.now();
        }
        else {
            toDatee = LocalDate.parse(toDate);
        }
        List<DailyReport> dailyReports = reportService.getReport(fromDatee, toDatee, type);
        model.addAttribute("report", dailyReports);
        model.addAttribute("fromDate", fromDate);
        model.addAttribute("toDate", toDate);
        model.addAttribute("type", type);
        return REPORT;
    }


}
