package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import com.example.gaecksocreative.domain.severance.repository.SeverancePayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeverancePayService {
    private final SeverancePayRepository severancePayRepository;

    public List<SeverancePayDTO> findAll() {
        List<SeverancePay> severancePayList = severancePayRepository.findAll();
        List<SeverancePayDTO> severancePayDTOList = new ArrayList<>();

        severancePayList.forEach(s -> severancePayDTOList.add(SeverancePayDTO.convertToDto(s)));

        return  severancePayDTOList;
    }

    public List<SeverancePayDTO> findByEmployeeId(int employeeId) {
        return severancePayRepository.findByEmployeeId(employeeId)
                .stream()
                .map(SeverancePayDTO::convertToDto)
                .collect(Collectors.toList());
    }

    public List<SeverancePayDTO> findByDateRange(Date startDate, Date endDate) {
        return severancePayRepository.findByDateBetween(startDate, endDate)
                .stream()
                .map(SeverancePayDTO::convertToDto)
                .collect(Collectors.toList());
    }

    public List<SeverancePayDTO> findByEmployeeIdAndDateRange(int employeeId, Date startDate, Date endDate) {
        return severancePayRepository.findByEmployeeIdAndDateBetween(employeeId, startDate, endDate)
                .stream()
                .map(SeverancePayDTO::convertToDto)
                .collect(Collectors.toList());
    }
}
