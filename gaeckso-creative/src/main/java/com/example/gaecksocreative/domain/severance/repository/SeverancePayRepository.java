package com.example.gaecksocreative.domain.severance.repository;

import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Date;

public interface SeverancePayRepository extends JpaRepository<SeverancePay, Integer> {
    List<SeverancePay> findByEmployeeIdAndDate(int employeeId, Date date);
}
