package com.example.gaecksocreative.domain.main;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class mainService {

    public ResponseEntity getPerson(dto dto) {

        return ResponseEntity.ok("ok");
    }
}
