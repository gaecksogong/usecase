package com.example.gaecksocreative.domain.asset;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "asset")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "cost", nullable = false)
    private Integer cost;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "loss", nullable = false)
    private Integer loss;

    @Column(name = "disposal", nullable = false)
    private Integer disposal;
}
