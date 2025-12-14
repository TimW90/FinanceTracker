package com.westerhuis.finance_tracker.financeitem;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
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

    public Double calculateBalance(List<FinanceItem> FinanceItems) {
        return FinanceItems
                .stream()
                .mapToDouble(financeItem ->
                        financeItem.getType() == INCOME ? financeItem.getAmount() : -financeItem.getAmount())
                .sum();
    }

    public Double calculateMonthlyBalance(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate startOfMonth = yearMonth.atDay(1);
        LocalDate endOfMonth = yearMonth.atEndOfMonth();

        List<FinanceItem> monthlyFinanceItems = financeItemRepository.findByDateBetween(startOfMonth, endOfMonth);
        return calculateBalance(monthlyFinanceItems);
    }

    public Double calculateYearlyBalance(int year) {
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);

        List<FinanceItem> yearlyFinanceItems = financeItemRepository.findByDateBetween(startOfYear, endOfYear);
        return calculateBalance(yearlyFinanceItems);
    }



}
