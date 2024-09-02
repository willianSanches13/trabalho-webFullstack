package org.example.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponSkinChroma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayName;
    private String displayIcon;
    private String fullRender;
    private String swatch;
    private String assetPath;

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

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getFullRender() {
        return fullRender;
    }

    public void setFullRender(String fullRender) {
        this.fullRender = fullRender;
    }

    public String getSwatch() {
        return swatch;
    }

    public void setSwatch(String swatch) {
        this.swatch = swatch;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }
}
