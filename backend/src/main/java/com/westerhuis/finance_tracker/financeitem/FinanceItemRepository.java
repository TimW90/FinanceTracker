package com.westerhuis.finance_tracker.financeitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FinanceItemRepository extends JpaRepository<FinanceItem, UUID> {

}
