package com.example.gaecksocreative.domain.budget.dto;

import com.example.gaecksocreative.domain.budget.BudgetEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
public class BudgetDto {
    private int id;
    private int manager;
    private int cost;
    private String description;
    private String name;
    private boolean status;
    private String managerName;

    public BudgetDto(int id, int manager, int cost, String description, String name, boolean status, String managerName) {
        this.id = id;
        this.manager = manager;
        this.cost = cost;
        this.description = description;
        this.name = name;
        this.status = status;
        this.managerName = managerName;

    }

    public static BudgetDto convertToDto(BudgetEntity budget) {
        return BudgetDto.builder()
                .id(budget.getId())
                .manager(budget.getManager())
                .cost(budget.getCost())
                .description(budget.getDescription())
                .name(budget.getName())
                .status(budget.isStatus())
                .managerName(budget.getManagerName())
                .build();
    }

    public static BudgetEntity convertToEntity(BudgetDto budgetDto) {
        return BudgetEntity.builder()
                .id(budgetDto.getId())
                .manager(budgetDto.getManager())
                .cost(budgetDto.getCost())
                .description(budgetDto.getDescription())
                .name(budgetDto.getName())
                .status(budgetDto.isStatus())
                .managerName(budgetDto.getManagerName())
                .build();
    }
}
