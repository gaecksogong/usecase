package com.example.gaecksocreative.domain.severance.dao;

import com.example.gaecksocreative.domain.severance.entity.SeverancePay;
import java.util.Date;
import java.util.List;

public interface SeverancePayDAO {
    List<SeverancePay> findByEmployeeIdAndDate(int employeeId, Date date);
}
