package org.example.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponSkinDTO {
    private Long id;
    private String displayName;
    private String themeUuid;
    private String contentTierUuid;
    private String displayIcon;
    private String assetPath;
    private List<WeaponSkinChromaDTO> chromas;
    private List<WeaponSkinLevelDTO> levels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getThemeUuid() {
        return themeUuid;
    }

    public void setThemeUuid(String themeUuid) {
        this.themeUuid = themeUuid;
    }

    public String getContentTierUuid() {
        return contentTierUuid;
    }

    public void setContentTierUuid(String contentTierUuid) {
        this.contentTierUuid = contentTierUuid;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }

    public List<WeaponSkinChromaDTO> getChromas() {
        return chromas;
    }

    public void setChromas(List<WeaponSkinChromaDTO> chromas) {
        this.chromas = chromas;
    }

    public List<WeaponSkinLevelDTO> getLevels() {
        return levels;
    }

    public void setLevels(List<WeaponSkinLevelDTO> levels) {
        this.levels = levels;
    }
}