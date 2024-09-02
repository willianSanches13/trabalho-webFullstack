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
public class WeaponStatsDTO {
    private Long id;
    private float fireRate;
    private int magazineSize;
    private float runSpeedMultiplier;
    private float equipTimeSeconds;
    private float reloadTimeSeconds;
    private float firstBulletAccuracy;
    private int shotgunPelletCount;
    private String wallPenetration;
    private String feature;
    private String fireMode;
    private String altFireType;
    private WeaponAdsStatsDTO adsStats;
    private WeaponsShotgunStatsDTO altShotgunStats;
    private WeaponsBurstStatsDTO airBurstStats;
    private List<WeaponDamageRangeDTO> damageRanges;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getFireRate() {
        return fireRate;
    }

    public void setFireRate(float fireRate) {
        this.fireRate = fireRate;
    }

    public int getMagazineSize() {
        return magazineSize;
    }

    public void setMagazineSize(int magazineSize) {
        this.magazineSize = magazineSize;
    }

    public float getRunSpeedMultiplier() {
        return runSpeedMultiplier;
    }

    public void setRunSpeedMultiplier(float runSpeedMultiplier) {
        this.runSpeedMultiplier = runSpeedMultiplier;
    }

    public float getEquipTimeSeconds() {
        return equipTimeSeconds;
    }

    public void setEquipTimeSeconds(float equipTimeSeconds) {
        this.equipTimeSeconds = equipTimeSeconds;
    }

    public float getReloadTimeSeconds() {
        return reloadTimeSeconds;
    }

    public void setReloadTimeSeconds(float reloadTimeSeconds) {
        this.reloadTimeSeconds = reloadTimeSeconds;
    }

    public float getFirstBulletAccuracy() {
        return firstBulletAccuracy;
    }

    public void setFirstBulletAccuracy(float firstBulletAccuracy) {
        this.firstBulletAccuracy = firstBulletAccuracy;
    }

    public int getShotgunPelletCount() {
        return shotgunPelletCount;
    }

    public void setShotgunPelletCount(int shotgunPelletCount) {
        this.shotgunPelletCount = shotgunPelletCount;
    }

    public String getWallPenetration() {
        return wallPenetration;
    }

    public void setWallPenetration(String wallPenetration) {
        this.wallPenetration = wallPenetration;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getFireMode() {
        return fireMode;
    }

    public void setFireMode(String fireMode) {
        this.fireMode = fireMode;
    }

    public String getAltFireType() {
        return altFireType;
    }

    public void setAltFireType(String altFireType) {
        this.altFireType = altFireType;
    }

    public WeaponAdsStatsDTO getAdsStats() {
        return adsStats;
    }

    public void setAdsStats(WeaponAdsStatsDTO adsStats) {
        this.adsStats = adsStats;
    }

    public WeaponsShotgunStatsDTO getAltShotgunStats() {
        return altShotgunStats;
    }

    public void setAltShotgunStats(WeaponsShotgunStatsDTO altShotgunStats) {
        this.altShotgunStats = altShotgunStats;
    }

    public WeaponsBurstStatsDTO getAirBurstStats() {
        return airBurstStats;
    }

    public void setAirBurstStats(WeaponsBurstStatsDTO airBurstStats) {
        this.airBurstStats = airBurstStats;
    }

    public List<WeaponDamageRangeDTO> getDamageRanges() {
        return damageRanges;
    }

    public void setDamageRanges(List<WeaponDamageRangeDTO> damageRanges) {
        this.damageRanges = damageRanges;
    }
}