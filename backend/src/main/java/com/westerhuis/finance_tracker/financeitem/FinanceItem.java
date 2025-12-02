package com.westerhuis.finance_tracker.financeitem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class FinanceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    private Double amount;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private FinanceType type;

    public FinanceItem(String description, Double amount, LocalDate date, FinanceType type) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
    }

}
