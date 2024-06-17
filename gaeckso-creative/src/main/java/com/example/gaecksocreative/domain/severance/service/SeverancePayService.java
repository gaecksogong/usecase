package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import com.example.gaecksocreative.domain.severance.repository.SeverancePayRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeverancePayService {
    private final SeverancePayRepository severancePayRepository;

    public SeverancePayService(SeverancePayRepository severancePayRepository) {
        this.severancePayRepository = severancePayRepository;
    }

    public List<SeverancePayDTO> getSeverancePayByEmployeeIdAndDate(int employeeId, Date date) {
        List<SeverancePay> severancePays = severancePayRepository.findByEmployeeIdAndDate(employeeId, date);
        return severancePays.stream()
                .map(severancePay -> SeverancePayDTO.builder()
                        .employeeId(severancePay.getEmployeeId())
                        .amount(severancePay.getAmount())
                        .date(severancePay.getDate())
                        .build())
                .collect(Collectors.toList());
    }
}
