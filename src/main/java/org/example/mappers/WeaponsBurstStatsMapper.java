package org.example.mappers;

import org.example.domain.entity.WeaponsBurstStats;
import org.example.rest.dto.WeaponsBurstStatsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class WeaponsBurstStatsMapper {

    public WeaponsBurstStatsDTO toWeaponsBurstStatsDTO(WeaponsBurstStats weaponsBurstStats) {
        if ( weaponsBurstStats == null ) {
            return null;
        }

        WeaponsBurstStatsDTO weaponsBurstStatsDTO = new WeaponsBurstStatsDTO();

        weaponsBurstStatsDTO.setId( weaponsBurstStats.getId() );
        weaponsBurstStatsDTO.setShotgunPelletCount( weaponsBurstStats.getShotgunPelletCount() );
        weaponsBurstStatsDTO.setBurstsDistance( weaponsBurstStats.getBurstsDistance() );

        return weaponsBurstStatsDTO;
    }

    public WeaponsBurstStats toWeaponsBurstStats(WeaponsBurstStatsDTO weaponsBurstStatsDTO) {
        if ( weaponsBurstStatsDTO == null ) {
            return null;
        }

        WeaponsBurstStats weaponsBurstStats = new WeaponsBurstStats();

        weaponsBurstStats.setShotgunPelletCount( weaponsBurstStatsDTO.getShotgunPelletCount() );
        weaponsBurstStats.setBurstsDistance( weaponsBurstStatsDTO.getBurstsDistance() );

        return weaponsBurstStats;
    }
}