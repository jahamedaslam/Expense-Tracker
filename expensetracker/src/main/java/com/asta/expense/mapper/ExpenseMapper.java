package com.asta.expense.mapper;

import com.asta.expense.model.Expense;
import com.asta.expense.payload.dto.ExpenseForm;
import com.asta.expense.reftype.YNStatus;
import com.asta.expense.utils.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("ExpenseMapper")
public class ExpenseMapper {

    public Expense map(ExpenseForm expenseForm) {
        Expense expense = new Expense();
        expense.setExpenseName(expenseForm.getExpenseName());
        expense.setDescription(expenseForm.getDescription());
        expense.setDate(LocalDate.parse(expenseForm.getDate()));
        expense.setAmount(new BigDecimal(expenseForm.getAmount()));
        expense.setDeleted(YNStatus.NO.getStatus());
        expense.setCreatedBy(StringUtils.user);
        expense.setCreatedOn(StringUtils.now);
        return expense;
    }

    public ExpenseForm remap(Expense expense) {
        ExpenseForm expenseForm = new ExpenseForm();
        expenseForm.setId(String.valueOf(expense.getId()));
        expenseForm.setExpenseName(expense.getExpenseName());
        expenseForm.setDescription(expense.getDescription());
        expenseForm.setDate(String.valueOf(expense.getDate()));
        expenseForm.setAmount(String.valueOf(expense.getAmount()));
        return expenseForm;
    }

    public Expense map (ExpenseForm expenseForm, Expense expense){
        expense.setExpenseName(expenseForm.getExpenseName());
        expense.setDescription(expenseForm.getDescription());
        expense.setAmount(new BigDecimal(expenseForm.getAmount()));
        expense.setDate(LocalDate.parse(expenseForm.getDate()));
        expense.setDeleted(YNStatus.NO.getStatus());
        expense.setUpdatedBy(StringUtils.user);
        expense.setUpdatedOn(StringUtils.now);
        return expense;
    }

    public List<ExpenseForm> listExpenseForm(List<Expense> articles) {
        List<ExpenseForm> expenseForms = new ArrayList<>();
        for (Expense expense : articles) {
            ExpenseForm expenseForm = new ExpenseForm();
            expenseForm.setId(String.valueOf(expense.getId()));
            expenseForm.setExpenseName(expense.getExpenseName());
            expenseForm.setDescription(expense.getDescription());
            expenseForm.setAmount(String.valueOf(expense.getAmount()));
            expenseForm.setDate(String.valueOf(expense.getDate()));
            expenseForms.add(expenseForm);
        }

        return expenseForms;
    }
}
