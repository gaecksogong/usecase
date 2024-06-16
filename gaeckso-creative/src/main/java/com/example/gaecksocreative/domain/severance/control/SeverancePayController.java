package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.service.SeverancePayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/severancePay")
public class SeverancePayController {
    private final SeverancePayService severancePayService;

    public SeverancePayController(SeverancePayService severancePayService) {
        this.severancePayService = severancePayService;
    }

    @GetMapping
    public List<SeverancePayDTO> getSeverancePayByEmployeeIdAndDate(@RequestParam int employeeId, @RequestParam Date date) {
        return severancePayService.getSeverancePayByEmployeeIdAndDate(employeeId, date);
    }
}
