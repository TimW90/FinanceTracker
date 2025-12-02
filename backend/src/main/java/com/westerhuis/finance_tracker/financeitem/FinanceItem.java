package com.westerhuis.finance_tracker.financeitem;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private double amount;

    private String date; //Todo: turn it into LocalDateTime

    @Enumerated(EnumType.STRING)
    private FinanceType type;

}
