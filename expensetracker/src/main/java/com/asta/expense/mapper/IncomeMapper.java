package com.asta.expense.mapper;


import com.asta.expense.model.Income;
import com.asta.expense.payload.dto.IncomeForm;
import com.asta.expense.reftype.YNStatus;
import com.asta.expense.utils.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("IncomeMapper")
public class IncomeMapper {

    public Income map(IncomeForm incomeForm) {
        Income income = new Income();
        income.setIncomeName(incomeForm.getIncomeName());
        income.setDescription(incomeForm.getDescription());
        income.setDate(LocalDate.parse(incomeForm.getDate()));
        income.setAmount(new BigDecimal(incomeForm.getAmount()));
        income.setDeleted(YNStatus.NO.getStatus());
        income.setCreatedBy(StringUtils.user);
        income.setCreatedOn(StringUtils.now);
        return income;
    }

    public IncomeForm remap(Income income) {
        IncomeForm incomeForm = new IncomeForm();
        incomeForm.setId(String.valueOf(income.getId()));
        incomeForm.setIncomeName(income.getIncomeName());
        incomeForm.setDescription(income.getDescription());
        incomeForm.setDate(String.valueOf(income.getDate()));
        incomeForm.setAmount(String.valueOf(income.getAmount()));
        return incomeForm;
    }

    public Income map(IncomeForm incomeForm, Income income) {
        income.setIncomeName(incomeForm.getIncomeName());
        income.setDescription(incomeForm.getDescription());
        income.setAmount(new BigDecimal(incomeForm.getAmount()));
        income.setDate(LocalDate.parse(incomeForm.getDate()));
        income.setDeleted(YNStatus.NO.getStatus());
        income.setUpdatedBy(StringUtils.user);
        income.setUpdatedOn(StringUtils.now);
        return income;
    }

    public List<IncomeForm> listIncomeForm(List<Income> articles) {
        List<IncomeForm> incomeForms = new ArrayList<>();
        for (Income income : articles) {
            IncomeForm incomeForm = new IncomeForm();
            incomeForm.setId(String.valueOf(income.getId()));
            incomeForm.setIncomeName(income.getIncomeName());
            incomeForm.setDescription(income.getDescription());
            incomeForm.setAmount(String.valueOf(income.getAmount()));
            incomeForm.setDate(String.valueOf(income.getDate()));
            incomeForms.add(incomeForm);
        }

        return incomeForms;
    }
}
