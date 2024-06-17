package com.example.gaecksocreative.domain.severance.dto;

import com.example.gaecksocreative.domain.severance.entity.SeveranceResolution;
import lombok.Builder;
import lombok.Getter;
import java.util.Date;

@Builder
@Getter
public class SeveranceResolutionDTO {

    private int severancePayId;
    private String description;
    private int approvalStatus;
    private Date date;

    public static SeveranceResolutionDTO convertToDto(SeveranceResolution severanceResolution) {
        return SeveranceResolutionDTO.builder()
                .severancePayId(severanceResolution.getSeverancePayId())
                .description(severanceResolution.getDescription())
                .approvalStatus(severanceResolution.getApprovalStatus())
                .date(severanceResolution.getDate())
                .build();
    }
}
