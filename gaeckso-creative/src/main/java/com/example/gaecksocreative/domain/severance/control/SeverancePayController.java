package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.severance.dto.SeverancePayDTO;
import com.example.gaecksocreative.domain.severance.service.SeverancePayService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/severancePay")
public class SeverancePayController {
    private final SeverancePayService severancePayService;

    @GetMapping("/")
    public String findAll(Model model){
        List<SeverancePayDTO> severancePayDTOList = severancePayService.findAll();
        model.addAttribute("severancePayList", severancePayDTOList);
        return "severancePay";
    }

    @GetMapping("/filter")
    public String findByCriteria(
            @RequestParam(name = "employeeId", required = false) Integer employeeId,
            @RequestParam(name = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate,
            Model model) {

        List<SeverancePayDTO> severancePayDTOList;

        if (employeeId != null && startDate != null && endDate != null) {
            severancePayDTOList = severancePayService.findByEmployeeIdAndDateRange(employeeId, startDate, endDate);
        } else if (employeeId != null) {
            severancePayDTOList = severancePayService.findByEmployeeId(employeeId);
        } else if (startDate != null && endDate != null) {
            severancePayDTOList = severancePayService.findByDateRange(startDate, endDate);
        } else {
            severancePayDTOList = severancePayService.findAll();
        }

        model.addAttribute("severancePayList", severancePayDTOList);
        return "severancePay";
    }
}
