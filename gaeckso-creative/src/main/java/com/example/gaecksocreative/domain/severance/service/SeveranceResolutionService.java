package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.entity.SeveranceResolution;
import com.example.gaecksocreative.domain.severance.repository.SeveranceResolutionRepository;
import org.springframework.stereotype.Service;

@Service
public class SeveranceResolutionService {
    private final SeveranceResolutionRepository severanceResolutionRepository;

    public SeveranceResolutionService(SeveranceResolutionRepository severanceResolutionRepository) {
        this.severanceResolutionRepository = severanceResolutionRepository;
    }

    public SeveranceResolutionDTO getSeveranceResolutionById(int id) {
        SeveranceResolution severanceResolution = severanceResolutionRepository.findById(id).orElseThrow();
        return SeveranceResolutionDTO.builder()
                .severancePayId(severanceResolution.getSeverancePayId())
                .description(severanceResolution.getDescription())
                .approvalStatus(severanceResolution.getApprovalStatus())
                .date(severanceResolution.getDate())
                .build();
    }
}
