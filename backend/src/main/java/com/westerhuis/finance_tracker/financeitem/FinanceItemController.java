package com.westerhuis.finance_tracker.financeitem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/finance")
public class FinanceItemController {

    private final FinanceItemRepository financeItemRepository;

    @GetMapping
    public List<FinanceItem> getAllFinance() {
        return financeItemRepository.findAll();
    }

    @PostMapping
    public FinanceItem addFinanceItem(@RequestBody FinanceItem newFinanceItem) {
        return financeItemRepository.save(newFinanceItem);
    }
}
