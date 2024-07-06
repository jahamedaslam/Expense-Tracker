package com.asta.expense.controller;

import com.asta.expense.mapper.DashboardData;
import com.asta.expense.mapper.DashboardMapper;
import com.asta.expense.model.Expense;
import com.asta.expense.model.Income;
import com.asta.expense.payload.dto.DashboardForm;
import com.asta.expense.service.expense.ExpenseService;
import com.asta.expense.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("dashboard")
public class DashboardController {

    private static final String DASHBOARD = "admin/dashboard";

    @Autowired
    @Qualifier("DashboardMapper")
    DashboardMapper dashboardMapper;
    @Autowired
    ExpenseService expenseService;

    @Autowired
    IncomeService incomeService;

    @GetMapping
    public String dashboardList(ModelMap model) {
        BigDecimal expensesAmount = expenseService.getTodayTotalExpenseAmount();
        BigDecimal incomeAmount = incomeService.getTodayTotalIncomeAmount();
        if (expensesAmount == null) {
            expensesAmount = BigDecimal.valueOf(0.00);
        }
        if (incomeAmount == null) {
            incomeAmount = BigDecimal.valueOf(0.00);
        }
        DashboardForm dashboardForm = dashboardMapper.map(expensesAmount, incomeAmount);
        model.addAttribute("dashboard", dashboardForm);
        return DASHBOARD;
    }
}
