package com.example.gaecksocreative.domain.asset;

import com.example.gaecksocreative.domain.asset.dto.AssetDto;

import java.util.List;

public interface AssetService {
    void saveAsset(AssetEntity assetEntity);
    List<AssetDto> getAllAssets();
    AssetDto getAssetById(Long id);
}
