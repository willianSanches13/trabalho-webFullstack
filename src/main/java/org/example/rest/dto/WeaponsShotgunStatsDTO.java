package org.example.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponsShotgunStatsDTO {
    private Long id;
    private int shotgunPelletCount;
    private float burstRate;

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

    public float getBurstRate() {
        return burstRate;
    }

    public void setBurstRate(float burstRate) {
        this.burstRate = burstRate;
    }
}
