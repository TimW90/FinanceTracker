package com.westerhuis.finance_tracker.financeitem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.westerhuis.finance_tracker.financeitem.FinanceType.INCOME;


@Service
@RequiredArgsConstructor
public class FinanceItemService {

    private final FinanceItemRepository financeItemRepository;

    public List<FinanceItem> findAll() {
        return financeItemRepository.findAll();
    }

    public FinanceItem addFinanceItem(FinanceItem newFinanceItem) {
        return financeItemRepository.save(newFinanceItem);
    }

    public Double calculateBalance() {
        return financeItemRepository.findAll()
                .stream()
                .mapToDouble(financeItem ->
                        financeItem.getType() == INCOME ? financeItem.getAmount() : -financeItem.getAmount())
                .sum();
    }


}
