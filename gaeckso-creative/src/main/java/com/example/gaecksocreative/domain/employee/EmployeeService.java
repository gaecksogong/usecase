package com.example.gaecksocreative.domain.employee;

import com.example.gaecksocreative.domain.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;


    public EmployeeDto getByIdEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return EmployeeDto.convertToDto(employee);
    }

    public Long getEmployeeId(EmployeeDto employee) {
        EmployeeEntity employeeEntity = employeeRepository.findByNameAndAgeAndSex(employee.getName(), employee.getAge(), employee.isSex())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        return employeeEntity.getId();
    }
}
