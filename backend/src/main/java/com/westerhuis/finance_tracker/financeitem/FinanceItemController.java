package com.westerhuis.finance_tracker.financeitem;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("api/v1/finance")
public class FinanceItemController {

    private final FinanceItemService financeItemService;

    @GetMapping
    public ResponseEntity<List<FinanceItem>> getAllFinance() {
        List<FinanceItem> result = financeItemService.findAll();

        if (result.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<FinanceItem> newFinanceItem(@RequestBody FinanceItem newFinanceItem) {
        FinanceItem addedItem = financeItemService.addFinanceItem(newFinanceItem);

        return ResponseEntity.created(URI.create("/finance" + addedItem.getId())).body(addedItem);
    }

    @GetMapping("/balance/month/{year}/{month}")
    public ResponseEntity<Double> getMonthlyBalance(@PathVariable("year") int year, @PathVariable("month") int month) {
        return ResponseEntity.ok(financeItemService.calculateMonthlyBalance(year, month));
    }

    @GetMapping("/balance/year/{year}")
    public ResponseEntity<Double> getYearlyBalance(@PathVariable("year") int year) {
        return ResponseEntity.ok(financeItemService.calculateYearlyBalance(year));
    }
}
