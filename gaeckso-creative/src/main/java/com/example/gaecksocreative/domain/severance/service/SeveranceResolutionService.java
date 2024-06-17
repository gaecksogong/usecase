package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import com.example.gaecksocreative.domain.severance.entity.SeveranceResolution;
import com.example.gaecksocreative.domain.severance.repository.SeverancePayRepository;
import com.example.gaecksocreative.domain.severance.repository.SeveranceResolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class SeveranceResolutionService {
    private final SeveranceResolutionRepository severanceResolutionRepository;
    private final SeverancePayRepository severancePayRepository;

    public void saveSeveranceResolutionWithPay(SeveranceResolutionDTO resolutionDTO, SeverancePayDTO payDTO) {
        SeverancePay severancePay = SeverancePay.convertToEntity(payDTO);
        severancePay = severancePayRepository.save(severancePay);

        SeveranceResolution severanceResolution = SeveranceResolution.builder()
                .severancePayId(severancePay.getId())
                .description(resolutionDTO.getDescription())
                .date(new Date())
                .approvalStatus("승인됨")
                .build();
        severanceResolutionRepository.save(severanceResolution);
    }
}