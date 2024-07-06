package com.asta.expense.service.expense;

import com.asta.expense.dao.ExpenseRepository;
import com.asta.expense.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    @Override
    public List<Expense> listAllTask() {
        return expenseRepository.findAll();
    }

}