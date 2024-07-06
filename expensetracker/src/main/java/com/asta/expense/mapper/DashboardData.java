package com.asta.expense.mapper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DashboardData {

    private List<BigDecimal> income;
    private List<BigDecimal> expense;
    private List<String> dates;
}
