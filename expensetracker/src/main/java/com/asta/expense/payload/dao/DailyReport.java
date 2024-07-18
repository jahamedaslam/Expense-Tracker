package com.asta.expense.payload.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DailyReport {
    private String id;
    private String Name;
    private BigDecimal amount;
    private String date;
    private String description;
    private int type;
}
