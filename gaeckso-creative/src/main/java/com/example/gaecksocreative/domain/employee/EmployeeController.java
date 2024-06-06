package com.example.gaecksocreative.domain.employee;

import com.example.gaecksocreative.domain.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("getById")
    public ResponseEntity<?> getEmployee(@RequestParam Long id) {
        return ResponseEntity.ok().body(employeeService.getByIdEmployee(id));
    }

    @PostMapping("get/dto")
    public ResponseEntity<?> getEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok().body(employeeService.getEmployeeId(employeeDto));
    }
}
