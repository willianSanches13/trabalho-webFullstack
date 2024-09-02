package org.example.mappers;

import org.example.domain.entity.WeaponSkinLevel;
import org.example.rest.dto.WeaponSkinLevelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class WeaponSkinLevelMapper {

    public WeaponSkinLevelDTO toWeaponSkinLevelDTO(WeaponSkinLevel weaponSkinLevel) {
        if ( weaponSkinLevel == null ) {
            return null;
        }

        WeaponSkinLevelDTO weaponSkinLevelDTO = new WeaponSkinLevelDTO();

        weaponSkinLevelDTO.setId( weaponSkinLevel.getId() );
        weaponSkinLevelDTO.setDisplayName( weaponSkinLevel.getDisplayName() );
        weaponSkinLevelDTO.setLevelItem( weaponSkinLevel.getLevelItem() );
        weaponSkinLevelDTO.setDisplayIcon( weaponSkinLevel.getDisplayIcon() );

        return weaponSkinLevelDTO;
    }

    public WeaponSkinLevel toWeaponSkinLevel(WeaponSkinLevelDTO weaponSkinLevelDTO) {
        if ( weaponSkinLevelDTO == null ) {
            return null;
        }

        WeaponSkinLevel weaponSkinLevel = new WeaponSkinLevel();

        weaponSkinLevel.setDisplayName( weaponSkinLevelDTO.getDisplayName() );
        weaponSkinLevel.setLevelItem( weaponSkinLevelDTO.getLevelItem() );
        weaponSkinLevel.setDisplayIcon( weaponSkinLevelDTO.getDisplayIcon() );

        return weaponSkinLevel;
    }
}