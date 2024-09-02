package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayName;
    private String category;
    private String defaultSkinUuid;
    private String killStreamIcon;
    private String assetPath;

    @OneToOne(cascade = CascadeType.ALL)
    private WeaponStats weaponStats;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeaponSkin> skins;

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

    public WeaponStats getWeaponStats() {
        return weaponStats;
    }

    public void setWeaponStats(WeaponStats weaponStats) {
        this.weaponStats = weaponStats;
    }

    public List<WeaponSkin> getSkins() {
        return skins;
    }

    public void setSkins(List<WeaponSkin> skins) {
        this.skins = skins;
    }
}
