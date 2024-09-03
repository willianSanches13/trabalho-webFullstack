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
public class WeaponDTO {
    private Long id;
    private String displayName;
    private String category;
    private String defaultSkinUuid;
    private String killStreamIcon;
    private String file;
    private String assetPath;
    private WeaponStatsDTO weaponStats;
    private List<WeaponSkinDTO> skins;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefaultSkinUuid() {
        return defaultSkinUuid;
    }

    public void setDefaultSkinUuid(String defaultSkinUuid) {
        this.defaultSkinUuid = defaultSkinUuid;
    }

    public String getKillStreamIcon() {
        return killStreamIcon;
    }

    public void setKillStreamIcon(String killStreamIcon) {
        this.killStreamIcon = killStreamIcon;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }

    public WeaponStatsDTO getWeaponStats() {
        return weaponStats;
    }

    public void setWeaponStats(WeaponStatsDTO weaponStats) {
        this.weaponStats = weaponStats;
    }

    public List<WeaponSkinDTO> getSkins() {
        return skins;
    }

    public void setSkins(List<WeaponSkinDTO> skins) {
        this.skins = skins;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
