package com.example.gaecksocreative.domain.budget;

import com.example.gaecksocreative.domain.budget.dto.BudgetDto;
import com.example.gaecksocreative.domain.employee.EmployeeService;
import com.example.gaecksocreative.domain.employee.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {

    private final BudgetRepository budgetRepository;
    private final EmployeeService employeeService;

    @Autowired
    public BudgetServiceImpl(BudgetRepository budgetRepository, EmployeeService employeeService) {
        this.budgetRepository = budgetRepository;
        this.employeeService = employeeService;
    }

    @Override
    public void saveBudget(BudgetEntity budgetEntity) {
        budgetRepository.save(budgetEntity);
    }

    @Override
    public List<BudgetDto> getAllBudgets() {
        List<BudgetEntity> budgetEntities = budgetRepository.findAll();
        List<BudgetDto> budgetDtos = new ArrayList<>();
        for (BudgetEntity budgetEntity : budgetEntities) {
            BudgetDto budgetDto = BudgetDto.convertToDto(budgetEntity);
            EmployeeDto manager = employeeService.getByIdEmployee((long) budgetEntity.getManager());
            budgetDto.setManagerName(manager.getName());
            budgetDtos.add(budgetDto);
        }
        return budgetDtos;
    }
}