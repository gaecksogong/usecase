package com.example.gaecksocreative.domain.main;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final mainService mainService;

    @PostMapping("/get/person")
    public ResponseEntity<?> getPerson(@RequestBody dto dto) {

        return mainService.getPerson(dto);
    }
}
