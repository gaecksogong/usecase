package com.example.gaecksocreative.domain.severance.entity;

import com.example.gaecksocreative.domain.severance.dto.SeveranceResolutionDTO;
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
@Table(name = "severanceResolution")
public class SeveranceResolution {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private int severancePayId;
    @Column
    private String description;
    @Column
    private String approvalStatus;
    @Column
    private Date date;

    public static SeveranceResolution convertToEntity(SeveranceResolutionDTO severanceResolutionDTO){
        return SeveranceResolution.builder()
                .id(severanceResolutionDTO.getId())
                .severancePayId(severanceResolutionDTO.getSeverancePayId())
                .description(severanceResolutionDTO.getDescription())
                .approvalStatus(severanceResolutionDTO.getApprovalStatus())
                .date(severanceResolutionDTO.getDate())
                .build();
    }
}
