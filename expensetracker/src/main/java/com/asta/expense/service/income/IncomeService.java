package com.asta.expense.service.income;

import com.asta.expense.model.Income;

import java.util.List;
import java.util.Optional;

public interface IncomeService {

    public List<Income> listAllIncomes();

    public Income saveIncome(Income income);

    public Optional<Income> getIncomeById(Long id);

    public Income updateIncome(Income income);

    public Income deleteIncome(Long id);
}
