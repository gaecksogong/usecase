package com.example.gaecksocreative.domain.severance.dto;

import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeverancePayDTO {
    private int id;
    private int employeeId;
    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public static SeverancePayDTO convertToDto(SeverancePay severancePay) {
        return SeverancePayDTO.builder()
                .id(severancePay.getId())
                .employeeId(severancePay.getEmployeeId())
                .amount(severancePay.getAmount())
                .date(severancePay.getDate())
                .build();
    }
}