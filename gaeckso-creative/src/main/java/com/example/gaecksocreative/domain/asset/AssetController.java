package com.example.gaecksocreative.domain.asset;

import com.example.gaecksocreative.domain.asset.dto.AssetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    @Autowired
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    public String getAllAssets(Model model) {
        List<AssetDto> assets = assetService.getAllAssets();
        model.addAttribute("assets", assets);
        return "assetList";
    }

    @GetMapping("/{id}")
    public String getAssetById(@PathVariable Long id, Model model) {
        AssetDto asset = assetService.getAssetById(id);
        model.addAttribute("asset", asset);
        return "assetDetail";
    }

    @GetMapping("/new")
    public String createAssetForm(Model model) {
        model.addAttribute("asset", new AssetDto());
        return "assetForm";
    }

    @PostMapping
    public String saveAsset(@ModelAttribute AssetDto assetDto) {
        AssetEntity assetEntity = AssetEntity.builder()
                .id(assetDto.getId())
                .date(assetDto.getDate())
                .cost(assetDto.getCost())
                .name(assetDto.getName())
                .loss(assetDto.getLoss())
                .disposal(assetDto.getDisposal())
                .build();
        assetService.saveAsset(assetEntity);
        return "redirect:/assets";
    }
}
