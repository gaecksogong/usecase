package com.example.gaecksocreative.domain.asset.dto;

import com.example.gaecksocreative.domain.asset.AssetEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class AssetDto {

    private Long id;
    private LocalDate date;
    private Integer cost;
    private String name;
    private Integer loss;
    private Integer disposal;

    public static AssetDto convertToDto(AssetEntity assetEntity) {
        return AssetDto.builder()
                .id(assetEntity.getId())
                .date(assetEntity.getDate())
                .cost(assetEntity.getCost())
                .name(assetEntity.getName())
                .loss(assetEntity.getLoss())
                .disposal(assetEntity.getDisposal())
                .build();
    }

    @Builder
    public AssetDto(Long id, LocalDate date, Integer cost, String name, Integer loss, Integer disposal) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.name = name;
        this.loss = loss;
        this.disposal = disposal;
    }
}
