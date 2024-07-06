package com.asta.expense.service.expense;

import com.asta.expense.model.Expense;

import java.util.List;
import java.util.Optional;

public interface ExpenseService {

    public List<Expense> listAllExpenses();

    public Expense saveExpense(Expense expense);

    public Optional<Expense> getExpenseById(Long id);

    public Expense updateExpense(Expense expense);

    public Expense deleteExpense(Long id);

}
