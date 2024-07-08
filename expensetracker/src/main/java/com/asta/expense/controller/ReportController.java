package com.asta.expense.controller;

import com.asta.expense.payload.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("report")
public class ReportController {
    private static final String REPORT = "admin/report";
    @GetMapping("/list")
    public String getReport(Model model) {
        return REPORT;
    }

}
