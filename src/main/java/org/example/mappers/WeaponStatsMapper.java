package org.example.mappers;

import org.example.domain.entity.WeaponDamageRange;
import org.example.domain.entity.WeaponStats;
import org.example.rest.dto.WeaponDamageRangeDTO;
import org.example.rest.dto.WeaponStatsDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponStatsMapper {

    @Autowired
    private WeaponAdsStatsMapper weaponAdsStatsMapper;
    @Autowired
    private WeaponsShotgunStatsMapper weaponsShotgunStatsMapper;
    @Autowired
    private WeaponsBurstStatsMapper weaponsBurstStatsMapper;
    @Autowired
    private WeaponDamageRangeMapper weaponDamageRangeMapper;

    public WeaponStatsDTO toWeaponStatsDTO(WeaponStats weaponStats) {
        if ( weaponStats == null ) {
            return null;
        }

        WeaponStatsDTO weaponStatsDTO = new WeaponStatsDTO();

        weaponStatsDTO.setId( weaponStats.getId() );
        weaponStatsDTO.setFireRate( weaponStats.getFireRate() );
        weaponStatsDTO.setMagazineSize( weaponStats.getMagazineSize() );
        weaponStatsDTO.setRunSpeedMultiplier( weaponStats.getRunSpeedMultiplier() );
        weaponStatsDTO.setEquipTimeSeconds( weaponStats.getEquipTimeSeconds() );
        weaponStatsDTO.setReloadTimeSeconds( weaponStats.getReloadTimeSeconds() );
        weaponStatsDTO.setFirstBulletAccuracy( weaponStats.getFirstBulletAccuracy() );
        weaponStatsDTO.setShotgunPelletCount( weaponStats.getShotgunPelletCount() );
        weaponStatsDTO.setWallPenetration( weaponStats.getWallPenetration() );
        weaponStatsDTO.setFeature( weaponStats.getFeature() );
        weaponStatsDTO.setFireMode( weaponStats.getFireMode() );
        weaponStatsDTO.setAltFireType( weaponStats.getAltFireType() );
        weaponStatsDTO.setAdsStats( weaponAdsStatsMapper.toWeaponAdsStatsDTO( weaponStats.getAdsStats() ) );
        weaponStatsDTO.setAltShotgunStats( weaponsShotgunStatsMapper.toWeaponsShotgunStatsDTO( weaponStats.getAltShotgunStats() ) );
        weaponStatsDTO.setAirBurstStats( weaponsBurstStatsMapper.toWeaponsBurstStatsDTO( weaponStats.getAirBurstStats() ) );
        weaponStatsDTO.setDamageRanges( weaponDamageRangeListToWeaponDamageRangeDTOList( weaponStats.getDamageRanges() ) );

        return weaponStatsDTO;
    }

    public WeaponStats toWeaponStats(WeaponStatsDTO weaponStatsDTO) {
        if ( weaponStatsDTO == null ) {
            return null;
        }

        WeaponStats weaponStats = new WeaponStats();

        weaponStats.setFireRate( weaponStatsDTO.getFireRate() );
        weaponStats.setMagazineSize( weaponStatsDTO.getMagazineSize() );
        weaponStats.setRunSpeedMultiplier( weaponStatsDTO.getRunSpeedMultiplier() );
        weaponStats.setEquipTimeSeconds( weaponStatsDTO.getEquipTimeSeconds() );
        weaponStats.setReloadTimeSeconds( weaponStatsDTO.getReloadTimeSeconds() );
        weaponStats.setFirstBulletAccuracy( weaponStatsDTO.getFirstBulletAccuracy() );
        weaponStats.setShotgunPelletCount( weaponStatsDTO.getShotgunPelletCount() );
        weaponStats.setWallPenetration( weaponStatsDTO.getWallPenetration() );
        weaponStats.setFeature( weaponStatsDTO.getFeature() );
        weaponStats.setFireMode( weaponStatsDTO.getFireMode() );
        weaponStats.setAltFireType( weaponStatsDTO.getAltFireType() );
        weaponStats.setAdsStats( weaponAdsStatsMapper.toWeaponAdsStats( weaponStatsDTO.getAdsStats() ) );
        weaponStats.setAltShotgunStats( weaponsShotgunStatsMapper.toWeaponsShotgunStats( weaponStatsDTO.getAltShotgunStats() ) );
        weaponStats.setAirBurstStats( weaponsBurstStatsMapper.toWeaponsBurstStats( weaponStatsDTO.getAirBurstStats() ) );
        weaponStats.setDamageRanges( weaponDamageRangeDTOListToWeaponDamageRangeList( weaponStatsDTO.getDamageRanges() ) );

        return weaponStats;
    }

    protected List<WeaponDamageRangeDTO> weaponDamageRangeListToWeaponDamageRangeDTOList(List<WeaponDamageRange> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponDamageRangeDTO> list1 = new ArrayList<WeaponDamageRangeDTO>( list.size() );
        for ( WeaponDamageRange weaponDamageRange : list ) {
            list1.add( weaponDamageRangeMapper.toWeaponDamageRangeDTO( weaponDamageRange ) );
        }

        return list1;
    }

    protected List<WeaponDamageRange> weaponDamageRangeDTOListToWeaponDamageRangeList(List<WeaponDamageRangeDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponDamageRange> list1 = new ArrayList<WeaponDamageRange>( list.size() );
        for ( WeaponDamageRangeDTO weaponDamageRangeDTO : list ) {
            list1.add( weaponDamageRangeMapper.toWeaponDamageRange( weaponDamageRangeDTO ) );
        }

        return list1;
    }
}