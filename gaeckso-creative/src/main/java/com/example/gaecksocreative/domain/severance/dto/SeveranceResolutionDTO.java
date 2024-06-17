package com.example.gaecksocreative.domain.severance.dto;

import com.example.gaecksocreative.domain.severance.entity.SeveranceResolution;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SeveranceResolutionDTO {
    private int id;
    private int severancePayId;
    private String description;
    private String approvalStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public static SeveranceResolutionDTO convertToDto(SeveranceResolution severanceResolution) {
        return SeveranceResolutionDTO.builder()
                .id(severanceResolution.getId())
                .severancePayId(severanceResolution.getSeverancePayId())
                .description(severanceResolution.getDescription())
                .approvalStatus(severanceResolution.getApprovalStatus())
                .date(severanceResolution.getDate())
                .build();
    }
}
