package org.example.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponsBurstStatsDTO {
    private Long id;
    private int shotgunPelletCount;
    private float burstsDistance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getShotgunPelletCount() {
        return shotgunPelletCount;
    }

    public void setShotgunPelletCount(int shotgunPelletCount) {
        this.shotgunPelletCount = shotgunPelletCount;
    }

    public float getBurstsDistance() {
        return burstsDistance;
    }

    public void setBurstsDistance(float burstsDistance) {
        this.burstsDistance = burstsDistance;
    }
}