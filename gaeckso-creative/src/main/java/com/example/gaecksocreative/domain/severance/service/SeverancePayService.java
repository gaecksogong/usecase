package com.example.gaecksocreative.domain.severance.service;

import com.example.gaecksocreative.domain.severance.repository.SeverancePayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeverancePayService {
    private final SeverancePayRepository severancePayRepository;

}
