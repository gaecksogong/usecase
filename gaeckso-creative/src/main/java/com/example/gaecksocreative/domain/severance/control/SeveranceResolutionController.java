package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.employee.EmployeeService;
import com.example.gaecksocreative.domain.employee.dto.EmployeeDto;
import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.service.SeveranceResolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/severanceResolution")
public class SeveranceResolutionController {
    private final SeveranceResolutionService severanceResolutionService;
    private final EmployeeService employeeService;

    @GetMapping("/")
    public String saveForm() {
        return "severanceResolution";
    }

    @PostMapping("/")
    public String createSeveranceResolution(
            @RequestParam(name = "employeeId") int employeeId,
            @RequestParam(name = "amount") int amount,
            @RequestParam(name = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date,
            @RequestParam(name = "description") String description) {

        EmployeeDto employee = employeeService.getByIdEmployee((long) employeeId);

        SeverancePayDTO payDTO = SeverancePayDTO.builder()
                .employeeId(employeeId)
                .amount(amount)
                .date(date)
                .build();

        SeveranceResolutionDTO resolutionDTO = SeveranceResolutionDTO.builder()
                .description(description)
                .build();

        severanceResolutionService.saveSeveranceResolutionWithPay(resolutionDTO, payDTO);
        return "redirect:/severanceResolution/";
    }

    @GetMapping("/employee/{id}")
    @ResponseBody
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        try {
            EmployeeDto employee = employeeService.getByIdEmployee(id);
            return ResponseEntity.ok(employee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
