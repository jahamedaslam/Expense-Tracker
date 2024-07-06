package com.asta.expense.dao;

import com.asta.expense.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findAllByDeleted(String deleted);
    @Query("SELECT SUM(i.amount) FROM Income i WHERE i.date = :date and i.deleted = 'F'")
    BigDecimal getTotalIncomeAmountForToday(@Param("date") LocalDate date);

    List<Income> findAllByDateBetween(LocalDate startDate, LocalDate endDate);



}
