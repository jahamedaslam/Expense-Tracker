package com.asta.expense.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IncomeForm {

    private String id;
    private String incomeName;
    private String amount;
    private String date;
    private String description;
}
