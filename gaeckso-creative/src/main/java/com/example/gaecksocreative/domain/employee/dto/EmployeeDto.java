package com.example.gaecksocreative.domain.employee.dto;

import com.example.gaecksocreative.domain.employee.EmployeeEntity;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeDto {

    private String name;
    private boolean sex;
    private int age;

    public static EmployeeDto convertToDto(EmployeeEntity employee) {
        return EmployeeDto.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .sex(employee.isSex())
                .build();
    }
}
