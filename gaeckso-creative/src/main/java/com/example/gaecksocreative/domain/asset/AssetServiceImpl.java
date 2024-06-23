package com.example.gaecksocreative.domain.asset;

import com.example.gaecksocreative.domain.asset.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;

    @Autowired
    public AssetServiceImpl(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @Override
    public void saveAsset(AssetEntity assetEntity) {
        assetRepository.save(assetEntity);
    }

    @Override
    public List<AssetDto> getAllAssets() {
        return assetRepository.findAll().stream()
                .map(AssetDto::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AssetDto getAssetById(Long id) {
        Optional<AssetEntity> assetEntity = assetRepository.findById(id);
        return assetEntity.map(AssetDto::convertToDto).orElse(null);
    }
}
