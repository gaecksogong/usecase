package com.example.gaecksocreative.domain.severance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity(name = "severancePay")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeverancePay {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int employeeId;
    private int amount;
    private Date date;
}
