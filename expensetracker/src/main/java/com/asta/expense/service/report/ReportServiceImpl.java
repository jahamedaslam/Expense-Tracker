package com.asta.expense.service.report;

import com.asta.expense.dao.ExpenseRepository;
import com.asta.expense.dao.IncomeRepository;
import com.asta.expense.model.Expense;
import com.asta.expense.model.Income;
import com.asta.expense.payload.dao.DailyReport;
import com.asta.expense.reftype.YNStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private IncomeRepository incomeRepository;

    public List<DailyReport> getReport(LocalDate fromDate, LocalDate toDate, int type) {
        List<DailyReport> reports = new ArrayList<>();

        if (type == 1) {
            List<Expense> expenses = expenseRepository.findAllByDateBetween(fromDate, toDate);
            for (Expense expense : expenses) {
                reports.add(expenseToDailyReport(expense));
            }
        } else {
            List<Income> income = incomeRepository.findAllByDateBetween(fromDate, toDate);
            for (Income incomeItem : income) {
                reports.add(incomeToDailyReport(incomeItem));
            }
        }
        return reports;
    }

    private DailyReport incomeToDailyReport(Income income) {
        DailyReport report = new DailyReport();
        report.setId(String.valueOf(income.getId()));
        report.setName(income.getIncomeName());
        report.setAmount(income.getAmount());
        report.setDate(income.getDate().toString());
        report.setDescription(income.getDescription());
        report.setType(2);
        return report;
    }

    private DailyReport expenseToDailyReport(Expense expense) {
        DailyReport report = new DailyReport();
        report.setId(String.valueOf(expense.getId()));
        report.setName(expense.getExpenseName());
        report.setAmount(expense.getAmount());
        report.setDate(expense.getDate().toString());
        report.setDescription(expense.getDescription());
        report.setType(1);
        return report;
    }

    public Map<Month, BigDecimal[]> getMonthlyData() {
        Map<Month, BigDecimal[]> monthlyData = new EnumMap<>(Month.class);

        for (Month month : Month.values()) {
            monthlyData.put(month, new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO});
        }

        List<Expense> expenses = expenseRepository.findAllByDeleted(YNStatus.NO.getStatus());
        List<Income> incomes = incomeRepository.findAllByDeleted(YNStatus.NO.getStatus());

        for (Expense expense : expenses) {
            Month month = expense.getDate().getMonth();
            monthlyData.get(month)[0] = monthlyData.get(month)[0].add(expense.getAmount());
        }

        for (Income income : incomes) {
            Month month = income.getDate().getMonth();
            monthlyData.get(month)[1] = monthlyData.get(month)[1].add(income.getAmount());
        }

        return monthlyData;
    }
}
