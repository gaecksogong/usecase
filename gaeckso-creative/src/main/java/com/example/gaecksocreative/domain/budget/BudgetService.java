package com.example.gaecksocreative.domain.budget;

import com.example.gaecksocreative.domain.budget.dto.BudgetDto;

import java.util.List;

public interface BudgetService {
    void saveBudget(BudgetEntity budgetEntity);
    List<BudgetDto> getAllBudgets();
}
