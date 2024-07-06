package com.asta.expense.service.expense;

import com.asta.expense.dao.ExpenseRepository;
import com.asta.expense.model.Expense;
import com.asta.expense.reftype.YNStatus;
import com.asta.expense.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    @Override
    public List<Expense> listAllExpenses() {
        return expenseRepository.findAllByDeleted(YNStatus.NO.getStatus());
    }

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense deleteExpense(Long id) {
        Optional<Expense> expenseOptional = expenseRepository.findById(id);
        if (expenseOptional.isPresent()) {
            Expense expense = expenseOptional.get();
            expense.setUpdatedBy(StringUtils.user);
            expense.setUpdatedOn(StringUtils.now);
            expense.setDeleted(YNStatus.YES.getStatus());
            return expense;
        }
        return null;
    }

    @Override
    public BigDecimal getTodayTotalExpenseAmount() {
        LocalDate today = LocalDate.now();
        return expenseRepository.getTotalExpenseAmountForToday(today);
    }

    @Override
    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findAllByDateBetween(startDate, endDate);
    }

}