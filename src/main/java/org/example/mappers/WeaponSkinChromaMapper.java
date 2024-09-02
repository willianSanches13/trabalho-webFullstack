package org.example.mappers;

import org.example.domain.entity.WeaponSkinChroma;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.example.rest.dto.WeaponSkinChromaDTO;
import org.springframework.stereotype.Component;

@Component
public class WeaponSkinChromaMapper {

    public WeaponSkinChromaDTO toWeaponSkinChromaDTO(WeaponSkinChroma weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponSkinChromaDTO weaponSkinChromaDTO = new WeaponSkinChromaDTO();

        weaponSkinChromaDTO.setId( weapon.getId() );
        weaponSkinChromaDTO.setDisplayName( weapon.getDisplayName() );
        weaponSkinChromaDTO.setDisplayIcon( weapon.getDisplayIcon() );
        weaponSkinChromaDTO.setFullRender( weapon.getFullRender() );
        weaponSkinChromaDTO.setSwatch( weapon.getSwatch() );

        return weaponSkinChromaDTO;
    }

    public WeaponSkinChroma toWeaponSkinChroma(WeaponSkinChromaDTO weaponDTO) {
        if ( weaponDTO == null ) {
            return null;
        }

        WeaponSkinChroma weaponSkinChroma = new WeaponSkinChroma();

        weaponSkinChroma.setDisplayName( weaponDTO.getDisplayName() );
        weaponSkinChroma.setDisplayIcon( weaponDTO.getDisplayIcon() );
        weaponSkinChroma.setFullRender( weaponDTO.getFullRender() );
        weaponSkinChroma.setSwatch( weaponDTO.getSwatch() );

        return weaponSkinChroma;
    }
}
