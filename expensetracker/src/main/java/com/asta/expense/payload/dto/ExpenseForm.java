package com.asta.expense.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseForm {

    private String id;
    private String expenseName;
    private String amount;
    private String date;
    private String description;
}
