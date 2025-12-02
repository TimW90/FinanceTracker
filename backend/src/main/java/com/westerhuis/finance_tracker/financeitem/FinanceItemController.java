package com.westerhuis.finance_tracker.financeitem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/finance")
public class FinanceItemController {

    private final FinanceItemService financeItemService;

    @GetMapping
    public List<FinanceItem> getAllFinance() {
        return financeItemService.findAll();
    }

    @PostMapping
    public FinanceItem newFinanceItem(@RequestBody FinanceItem newFinanceItem) {
        return financeItemService.addFinanceItem(newFinanceItem);
    }

    @GetMapping("/balance")
    public Double getBalance() {
        return financeItemService.calculateBalance();
    }
}
