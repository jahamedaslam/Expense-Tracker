package com.asta.expense.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "EXPENSE")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "EXPENSE_NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DELETED")
    private String deleted;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_ON")
    private LocalDateTime createdOn;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_ON")
    private LocalDateTime updatedOn;
}


