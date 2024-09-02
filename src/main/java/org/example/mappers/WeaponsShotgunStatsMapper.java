package org.example.mappers;

import org.example.domain.entity.WeaponsShotgunStats;
import org.example.rest.dto.WeaponsShotgunStatsDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class WeaponsShotgunStatsMapper {

    public WeaponsShotgunStatsDTO toWeaponsShotgunStatsDTO(WeaponsShotgunStats weaponsShotgunStats) {
        if ( weaponsShotgunStats == null ) {
            return null;
        }

        WeaponsShotgunStatsDTO weaponsShotgunStatsDTO = new WeaponsShotgunStatsDTO();

        weaponsShotgunStatsDTO.setId( weaponsShotgunStats.getId() );
        weaponsShotgunStatsDTO.setShotgunPelletCount( weaponsShotgunStats.getShotgunPelletCount() );
        weaponsShotgunStatsDTO.setBurstRate( weaponsShotgunStats.getBurstRate() );

        return weaponsShotgunStatsDTO;
    }

    public WeaponsShotgunStats toWeaponsShotgunStats(WeaponsShotgunStatsDTO weaponsShotgunStatsDTO) {
        if ( weaponsShotgunStatsDTO == null ) {
            return null;
        }

        WeaponsShotgunStats weaponsShotgunStats = new WeaponsShotgunStats();

        weaponsShotgunStats.setShotgunPelletCount( weaponsShotgunStatsDTO.getShotgunPelletCount() );
        weaponsShotgunStats.setBurstRate( weaponsShotgunStatsDTO.getBurstRate() );

        return weaponsShotgunStats;
    }
}