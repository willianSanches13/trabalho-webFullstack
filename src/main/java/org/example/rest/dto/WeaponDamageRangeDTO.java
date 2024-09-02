package org.example.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeaponDamageRangeDTO {
    private Long id;
    private float rangeStartsMeters;
    private float rangeEndMeters;
    private float headDamage;
    private float bodyDamage;
    private float legDamage;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getRangeStartsMeters() {
        return rangeStartsMeters;
    }

    public void setRangeStartsMeters(float rangeStartsMeters) {
        this.rangeStartsMeters = rangeStartsMeters;
    }

    public float getRangeEndMeters() {
        return rangeEndMeters;
    }

    public void setRangeEndMeters(float rangeEndMeters) {
        this.rangeEndMeters = rangeEndMeters;
    }

    public float getHeadDamage() {
        return headDamage;
    }

    public void setHeadDamage(float headDamage) {
        this.headDamage = headDamage;
    }

    public float getBodyDamage() {
        return bodyDamage;
    }

    public void setBodyDamage(float bodyDamage) {
        this.bodyDamage = bodyDamage;
    }

    public float getLegDamage() {
        return legDamage;
    }

    public void setLegDamage(float legDamage) {
        this.legDamage = legDamage;
    }
}