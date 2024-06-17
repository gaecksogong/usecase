package com.example.gaecksocreative.domain.severance.control;

import com.example.gaecksocreative.domain.severance.service.SeverancePayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/severancePay")
public class SeverancePayController {
    private final SeverancePayService severancePayService;


    @GetMapping("/find")
    public String find(){
        return "severancePay";
    }
}
