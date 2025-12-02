package com.westerhuis.finance_tracker;

import com.westerhuis.finance_tracker.financeitem.FinanceItem;
import com.westerhuis.finance_tracker.financeitem.FinanceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.westerhuis.finance_tracker.financeitem.FinanceType.EXPENSE;
import static com.westerhuis.finance_tracker.financeitem.FinanceType.INCOME;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {

    private final FinanceItemRepository financeItemRepository;

    @Override
    public void run(String... args) throws Exception {

        if (financeItemRepository.count() == 0) {

            financeItemRepository.saveAll(List.of(
                    new FinanceItem("Main income", 2200.00, "Today", INCOME),
                    new FinanceItem("Secondary income", 400.00, "Today", INCOME),
                    new FinanceItem("Healthcare", 250.00, "Today", EXPENSE),
                    new FinanceItem("Rent", 850.00, "Today", EXPENSE),
                    new FinanceItem("Utilities", 250.00, "Today", EXPENSE),
                    new FinanceItem("Insurances", 100.00, "Today", EXPENSE),
                    new FinanceItem("Groceries", 250.00, "Today", EXPENSE)
                    )
            );
        }

    }


}