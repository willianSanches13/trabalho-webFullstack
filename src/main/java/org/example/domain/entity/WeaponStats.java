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
import javax.persistence.OneToOne;
import java.util.List;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne(cascade = CascadeType.ALL)
    private WeaponAdsStats adsStats;

    @OneToOne(cascade = CascadeType.ALL)
    private WeaponsShotgunStats altShotgunStats;

    @OneToOne(cascade = CascadeType.ALL)
    private WeaponsBurstStats airBurstStats;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<WeaponDamageRange> damageRanges;

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

    public WeaponAdsStats getAdsStats() {
        return adsStats;
    }

    public void setAdsStats(WeaponAdsStats adsStats) {
        this.adsStats = adsStats;
    }

    public WeaponsShotgunStats getAltShotgunStats() {
        return altShotgunStats;
    }

    public void setAltShotgunStats(WeaponsShotgunStats altShotgunStats) {
        this.altShotgunStats = altShotgunStats;
    }

    public WeaponsBurstStats getAirBurstStats() {
        return airBurstStats;
    }

    public void setAirBurstStats(WeaponsBurstStats airBurstStats) {
        this.airBurstStats = airBurstStats;
    }

    public List<WeaponDamageRange> getDamageRanges() {
        return damageRanges;
    }

    public void setDamageRanges(List<WeaponDamageRange> damageRanges) {
        this.damageRanges = damageRanges;
    }
}
