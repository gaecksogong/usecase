package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.entity.SeveranceResolution;
import com.example.gaecksocreative.domain.severance.repository.SeveranceResolutionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeveranceResolutionService {
    private final SeveranceResolutionRepository severanceResolutionRepository;

    public void save(SeveranceResolutionDTO severanceResolutionDTO){
        SeveranceResolution severanceResolution = SeveranceResolution.convertToEntity(severanceResolutionDTO);
        severanceResolutionRepository.save(severanceResolution);
    }
}