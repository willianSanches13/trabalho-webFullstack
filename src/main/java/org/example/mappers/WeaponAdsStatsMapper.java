package org.example.mappers;

import org.example.domain.entity.WeaponAdsStats;
import org.example.rest.dto.WeaponAdsStatsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class WeaponAdsStatsMapper {

    public WeaponAdsStatsDTO toWeaponAdsStatsDTO(WeaponAdsStats weaponAdsStats) {
        if ( weaponAdsStats == null ) {
            return null;
        }

        WeaponAdsStatsDTO weaponAdsStatsDTO = new WeaponAdsStatsDTO();

        weaponAdsStatsDTO.setId( weaponAdsStats.getId() );
        weaponAdsStatsDTO.setZoomMultiplier( weaponAdsStats.getZoomMultiplier() );
        weaponAdsStatsDTO.setFireRate( weaponAdsStats.getFireRate() );
        weaponAdsStatsDTO.setRunSpeedMultiplier( weaponAdsStats.getRunSpeedMultiplier() );
        weaponAdsStatsDTO.setBurstCount( weaponAdsStats.getBurstCount() );
        weaponAdsStatsDTO.setFirstBulletAccuracy( weaponAdsStats.getFirstBulletAccuracy() );

        return weaponAdsStatsDTO;
    }

    public WeaponAdsStats toWeaponAdsStats(WeaponAdsStatsDTO weaponAdsStatsDTO) {
        if ( weaponAdsStatsDTO == null ) {
            return null;
        }

        WeaponAdsStats weaponAdsStats = new WeaponAdsStats();

        weaponAdsStats.setZoomMultiplier( weaponAdsStatsDTO.getZoomMultiplier() );
        weaponAdsStats.setFireRate( weaponAdsStatsDTO.getFireRate() );
        weaponAdsStats.setRunSpeedMultiplier( weaponAdsStatsDTO.getRunSpeedMultiplier() );
        weaponAdsStats.setBurstCount( weaponAdsStatsDTO.getBurstCount() );
        weaponAdsStats.setFirstBulletAccuracy( weaponAdsStatsDTO.getFirstBulletAccuracy() );

        return weaponAdsStats;
    }
}
