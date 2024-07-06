package com.asta.expense.mapper;

import com.asta.expense.payload.dto.DashboardForm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Qualifier("DashboardMapper")
public class DashboardMapper {

    public DashboardForm map(BigDecimal expenseAmount, BigDecimal incomeAmount) {
        DashboardForm dashboardForm = new DashboardForm();
        dashboardForm.setExpenseAmount(String.valueOf(expenseAmount));
        dashboardForm.setIncomeAmount(String.valueOf(incomeAmount));
        return dashboardForm;
    }
}
