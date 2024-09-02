package org.example.rest.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponAdsStatsDTO {
    private Long id;
    private float zoomMultiplier;
    private float fireRate;
    private float runSpeedMultiplier;
    private int burstCount;
    private float firstBulletAccuracy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getZoomMultiplier() {
        return zoomMultiplier;
    }

    public void setZoomMultiplier(float zoomMultiplier) {
        this.zoomMultiplier = zoomMultiplier;
    }

    public float getFireRate() {
        return fireRate;
    }

    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }

    public float getRunSpeedMultiplier() {
        return runSpeedMultiplier;
    }

    public void setRunSpeedMultiplier(float runSpeedMultiplier) {
        this.runSpeedMultiplier = runSpeedMultiplier;
    }

    public int getBurstCount() {
        return burstCount;
    }

    public void setBurstCount(int burstCount) {
        this.burstCount = burstCount;
    }

    public float getFirstBulletAccuracy() {
        return firstBulletAccuracy;
    }

    public void setFirstBulletAccuracy(float firstBulletAccuracy) {
        this.firstBulletAccuracy = firstBulletAccuracy;
    }
}
