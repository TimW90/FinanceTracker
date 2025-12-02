package com.westerhuis.finance_tracker.financeitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface FinanceItemRepository extends JpaRepository<FinanceItem, UUID> {

    List<FinanceItem> findByDateBetween(LocalDate start, LocalDate end);

}
