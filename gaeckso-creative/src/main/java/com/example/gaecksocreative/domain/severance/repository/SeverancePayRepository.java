package com.example.gaecksocreative.domain.severance.repository;

import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SeverancePayRepository extends JpaRepository<SeverancePay, Integer> {
    List<SeverancePay> findByEmployeeId(int employeeId);
    List<SeverancePay> findByDateBetween(Date startDate, Date endDate);
    List<SeverancePay> findByEmployeeIdAndDateBetween(int employeeId, Date startDate, Date endDate);
}
