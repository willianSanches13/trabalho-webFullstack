package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponSkin {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayName;
    private String themeUuid;
    private String contentTierUuid;
    private String displayIcon;
    private String assetPath;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeaponSkinChroma> chromas;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeaponSkinLevel> levels;

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

    public List<WeaponSkinChroma> getChromas() {
        return chromas;
    }

    public void setChromas(List<WeaponSkinChroma> chromas) {
        this.chromas = chromas;
    }

    public List<WeaponSkinLevel> getLevels() {
        return levels;
    }

    public void setLevels(List<WeaponSkinLevel> levels) {
        this.levels = levels;
    }
}
