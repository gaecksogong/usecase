package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.service.SeveranceResolutionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/severanceResolution")
public class SeveranceResolutionController {
    private final SeveranceResolutionService severanceResolutionService;

    public SeveranceResolutionController(SeveranceResolutionService severanceResolutionService) {
        this.severanceResolutionService = severanceResolutionService;
    }

    @GetMapping
    public SeveranceResolutionDTO getSeveranceResolutionById(@RequestParam int id) {
        return severanceResolutionService.getSeveranceResolutionById(id);
    }
}
