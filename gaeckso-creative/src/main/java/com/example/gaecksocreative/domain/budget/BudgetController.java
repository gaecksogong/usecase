package com.example.gaecksocreative.domain.budget;

import com.example.gaecksocreative.domain.budget.dto.BudgetDto;
import com.example.gaecksocreative.domain.employee.EmployeeService;
import com.example.gaecksocreative.domain.employee.dto.EmployeeDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BudgetController {

    private final EmployeeService employeeService;
    private final BudgetService budgetService;

    public BudgetController(EmployeeService employeeService, BudgetService budgetService) {

        this.employeeService = employeeService;
        this.budgetService = budgetService;
    }

    @GetMapping("/budgetPage")
    public ModelAndView budgetLogin() {
        return new ModelAndView("budgetPage");
    }//예산 시작 페이지


    @GetMapping("/budget")
    public String getEmployeeById(@RequestParam(value = "id", required = false) Long id, Model model, HttpSession session) {
        if (id != null) {
            EmployeeDto employee = employeeService.getByIdEmployee(id);
            model.addAttribute("name", employee.getName());
            model.addAttribute("id", id);

            session.setAttribute("userId", id);
            session.setAttribute("userName", employee.getName());
        }
        return "budgetPage";
    }

    @GetMapping("/budgetRequest") //예산 신청 페이지
    public String budgetRequest(Model model, HttpSession session) {
        BudgetDto budgetDto = new BudgetDto();
        if (session.getAttribute("userId") != null) {
            Long userId = (Long) session.getAttribute("userId");
            budgetDto.setManager(userId.intValue());
            System.out.println("userId는: " + userId.intValue());  // Print userId
        }
        model.addAttribute("budget", budgetDto);
        model.addAttribute("name", session.getAttribute("userName"));
        return "budgetRequest";
    }

    @PostMapping("/budgetRequest")
    public String budgetRequestSubmit(@ModelAttribute BudgetDto budgetDto,HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        budgetDto.setManager(userId.intValue());
        System.out.println("budgetDto: " + budgetDto.getManager());  // Print budgetDto
        BudgetEntity budgetEntity = BudgetDto.convertToEntity(budgetDto);
        budgetService.saveBudget(budgetEntity);

        return "budgetPage";


    }

    @GetMapping("/budgetSearch")
    public String budgetSearch(@RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue, Model model) {
        List<BudgetDto> budgets = budgetService.getAllBudgets();

        if (searchType != null && !searchType.isEmpty() && searchValue != null && !searchValue.isEmpty()) {
            if (searchType.equals("managerName")) {
                budgets = budgets.stream()
                        .filter(budget -> budget.getManagerName().equals(searchValue))
                        .collect(Collectors.toList());
            } else if (searchType.equals("budgetName")) {
                budgets = budgets.stream()
                        .filter(budget -> budget.getName().equals(searchValue))
                        .collect(Collectors.toList());
            }
        }

        model.addAttribute("budgets", budgets);
        return "budgetSearch";
    }
}