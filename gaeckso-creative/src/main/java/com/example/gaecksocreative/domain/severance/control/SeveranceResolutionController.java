package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
import com.example.gaecksocreative.domain.severance.service.SeveranceResolutionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequiredArgsConstructor
@RequestMapping("/severanceResolution")
public class SeveranceResolutionController {
    private final SeveranceResolutionService severanceResolutionService;

    @GetMapping()
    public String saveForm(){
        return "severanceResolution";
    }

    @PostMapping()
    public String save(@ModelAttribute SeveranceResolutionDTO severanceResolutionDTO){
        severanceResolutionDTO.setDate(new Date());
        severanceResolutionDTO.setApprovalStatus("대기중");
        severanceResolutionService.save(severanceResolutionDTO);
        return "severanceResolution";
    }

}
