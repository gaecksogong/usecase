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

@Entity(name = "severanceResolution")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeveranceResolution {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int severancePayId;
    private String description;
    private int approvalStatus;
    private Date date;
}
