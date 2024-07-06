package com.asta.expense.service.income;

import com.asta.expense.dao.IncomeRepository;
import com.asta.expense.model.Income;
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
public class IncomeServiceImpl implements IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;


    @Override
    public List<Income> listAllIncomes() {
        return incomeRepository.findAllByDeleted(YNStatus.NO.getStatus());
    }

    @Override
    public Income saveIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Optional<Income> getIncomeById(Long id) {
        return incomeRepository.findById(id);
    }

    @Override
    public Income updateIncome(Income income) {
        return incomeRepository.save(income);
    }

    @Override
    public Income deleteIncome(Long id) {
        Optional<Income> incomeOptional = incomeRepository.findById(id);
        if (incomeOptional.isPresent()) {
            Income income = incomeOptional.get();
            income.setUpdatedBy(StringUtils.user);
            income.setUpdatedOn(StringUtils.now);
            income.setDeleted(YNStatus.YES.getStatus());
            return income;
        }
        return null;
    }

    @Override
    public BigDecimal getTodayTotalIncomeAmount() {
        LocalDate today = LocalDate.now();
        return incomeRepository.getTotalIncomeAmountForToday(today);
    }

    @Override
    public List<Income> getIncomesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findAllByDateBetween(startDate, endDate);
    }

}
