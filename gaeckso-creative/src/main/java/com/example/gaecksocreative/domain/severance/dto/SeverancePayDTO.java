package com.example.gaecksocreative.domain.severance.dto;

import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Builder
@Getter
public class SeverancePayDTO {

    private int employeeId;
    private int amount;
    private Date date;

    public static SeverancePayDTO convertToDto(SeverancePay severancePay) {
        return SeverancePayDTO.builder()
                .employeeId(severancePay.getEmployeeId())
                .amount(severancePay.getAmount())
                .date(severancePay.getDate())
                .build();
    }
}
