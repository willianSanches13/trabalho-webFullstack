package org.example.mappers;

import org.example.domain.entity.WeaponDamageRange;
import org.example.rest.dto.WeaponDamageRangeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class WeaponDamageRangeMapper {

    public WeaponDamageRangeDTO toWeaponDamageRangeDTO(WeaponDamageRange weaponDamageRange) {
        if ( weaponDamageRange == null ) {
            return null;
        }

        WeaponDamageRangeDTO weaponDamageRangeDTO = new WeaponDamageRangeDTO();

        weaponDamageRangeDTO.setId( weaponDamageRange.getId() );
        weaponDamageRangeDTO.setRangeStartsMeters( weaponDamageRange.getRangeStartsMeters() );
        weaponDamageRangeDTO.setRangeEndMeters( weaponDamageRange.getRangeEndMeters() );
        weaponDamageRangeDTO.setHeadDamage( weaponDamageRange.getHeadDamage() );
        weaponDamageRangeDTO.setBodyDamage( weaponDamageRange.getBodyDamage() );
        weaponDamageRangeDTO.setLegDamage( weaponDamageRange.getLegDamage() );

        return weaponDamageRangeDTO;
    }

    public WeaponDamageRange toWeaponDamageRange(WeaponDamageRangeDTO weaponDamageRangeDTO) {
        if ( weaponDamageRangeDTO == null ) {
            return null;
        }

        WeaponDamageRange weaponDamageRange = new WeaponDamageRange();

        weaponDamageRange.setRangeStartsMeters( weaponDamageRangeDTO.getRangeStartsMeters() );
        weaponDamageRange.setRangeEndMeters( weaponDamageRangeDTO.getRangeEndMeters() );
        weaponDamageRange.setHeadDamage( weaponDamageRangeDTO.getHeadDamage() );
        weaponDamageRange.setBodyDamage( weaponDamageRangeDTO.getBodyDamage() );
        weaponDamageRange.setLegDamage( weaponDamageRangeDTO.getLegDamage() );

        return weaponDamageRange;
    }
}
