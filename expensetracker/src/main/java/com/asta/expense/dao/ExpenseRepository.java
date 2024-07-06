package com.asta.expense.dao;

import com.asta.expense.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findAllByDeleted(String deleted);

    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.deleted = 'F' and e.date = :date")
    BigDecimal getTotalExpenseAmountForToday(@Param("date") LocalDate date);

    List<Expense> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

}
