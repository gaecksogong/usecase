package com.example.gaecksocreative.domain.severance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "severancePay")
public class SeverancePay {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int employeeId;
    @Column
    private int amount;
    @Column
    private Date date;
}
