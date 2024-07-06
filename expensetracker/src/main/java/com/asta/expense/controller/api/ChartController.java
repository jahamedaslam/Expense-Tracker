package com.asta.expense.controller.api;

import com.asta.expense.mapper.DashboardData;
import com.asta.expense.model.Expense;
import com.asta.expense.model.Income;
import com.asta.expense.service.expense.ExpenseService;
import com.asta.expense.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
public class ChartController {
    @Autowired
    ExpenseService expenseService;

    @Autowired
    IncomeService incomeService;

    @GetMapping("/chart-data")
    public DashboardData getDashboardData(@RequestParam("startDate") String startDateStr, @RequestParam("endDate") String endDateStr) {
        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        List<Expense> expenses = expenseService.getExpensesBetweenDates(startDate, endDate);
        List<Income> incomes = incomeService.getIncomesBetweenDates(startDate, endDate);

        List<BigDecimal> expenseAmounts = expenses.stream().map(Expense::getAmount).collect(Collectors.toList());
        List<BigDecimal> incomeAmounts = incomes.stream().map(Income::getAmount).collect(Collectors.toList());
        List<String> dates = expenses.stream().map(expense -> expense.getDate().toString()).collect(Collectors.toList());

        DashboardData data = new DashboardData();
        data.setExpense(expenseAmounts);
        data.setIncome(incomeAmounts);
        data.setDates(dates);
        return data;
    }
}
