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
public class WeaponsBurstStats {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
