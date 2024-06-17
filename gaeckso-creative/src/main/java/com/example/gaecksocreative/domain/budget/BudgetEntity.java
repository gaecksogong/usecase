package com.example.gaecksocreative.domain.budget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "budget")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int manager;
    private int cost;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String name;

    private boolean status;
    // t-1 대기,f-0 승인
    private String managerName;
}
