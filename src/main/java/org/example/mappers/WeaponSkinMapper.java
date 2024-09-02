package org.example.mappers;

import org.example.domain.entity.WeaponSkin;
import org.example.domain.entity.WeaponSkinChroma;
import org.example.domain.entity.WeaponSkinLevel;
import org.example.rest.dto.WeaponSkinChromaDTO;
import org.example.rest.dto.WeaponSkinDTO;
import org.example.rest.dto.WeaponSkinLevelDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponSkinMapper {
    @Autowired
    private WeaponSkinChromaMapper weaponSkinChromaMapper;
    @Autowired
    private WeaponSkinLevelMapper weaponSkinLevelMapper;

    public WeaponSkinDTO toWeaponSkinDTO(WeaponSkin weaponSkin) {
        if ( weaponSkin == null ) {
            return null;
        }

        WeaponSkinDTO weaponSkinDTO = new WeaponSkinDTO();

        weaponSkinDTO.setId( weaponSkin.getId() );
        weaponSkinDTO.setDisplayName( weaponSkin.getDisplayName() );
        weaponSkinDTO.setThemeUuid( weaponSkin.getThemeUuid() );
        weaponSkinDTO.setContentTierUuid( weaponSkin.getContentTierUuid() );
        weaponSkinDTO.setDisplayIcon( weaponSkin.getDisplayIcon() );
        weaponSkinDTO.setAssetPath( weaponSkin.getAssetPath() );
        weaponSkinDTO.setChromas( weaponSkinChromaListToWeaponSkinChromaDTOList( weaponSkin.getChromas() ) );
        weaponSkinDTO.setLevels( weaponSkinLevelListToWeaponSkinLevelDTOList( weaponSkin.getLevels() ) );

        return weaponSkinDTO;
    }

    public WeaponSkin toWeaponSkin(WeaponSkinDTO weaponSkinDTO) {
        if ( weaponSkinDTO == null ) {
            return null;
        }

        WeaponSkin weaponSkin = new WeaponSkin();

        weaponSkin.setDisplayName( weaponSkinDTO.getDisplayName() );
        weaponSkin.setThemeUuid( weaponSkinDTO.getThemeUuid() );
        weaponSkin.setContentTierUuid( weaponSkinDTO.getContentTierUuid() );
        weaponSkin.setDisplayIcon( weaponSkinDTO.getDisplayIcon() );
        weaponSkin.setAssetPath( weaponSkinDTO.getAssetPath() );
        weaponSkin.setChromas( weaponSkinChromaDTOListToWeaponSkinChromaList( weaponSkinDTO.getChromas() ) );
        weaponSkin.setLevels( weaponSkinLevelDTOListToWeaponSkinLevelList( weaponSkinDTO.getLevels() ) );

        return weaponSkin;
    }

    protected List<WeaponSkinChromaDTO> weaponSkinChromaListToWeaponSkinChromaDTOList(List<WeaponSkinChroma> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkinChromaDTO> list1 = new ArrayList<WeaponSkinChromaDTO>( list.size() );
        for ( WeaponSkinChroma weaponSkinChroma : list ) {
            list1.add( weaponSkinChromaMapper.toWeaponSkinChromaDTO( weaponSkinChroma ) );
        }

        return list1;
    }

    protected List<WeaponSkinLevelDTO> weaponSkinLevelListToWeaponSkinLevelDTOList(List<WeaponSkinLevel> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkinLevelDTO> list1 = new ArrayList<WeaponSkinLevelDTO>( list.size() );
        for ( WeaponSkinLevel weaponSkinLevel : list ) {
            list1.add( weaponSkinLevelMapper.toWeaponSkinLevelDTO( weaponSkinLevel ) );
        }

        return list1;
    }

    protected List<WeaponSkinChroma> weaponSkinChromaDTOListToWeaponSkinChromaList(List<WeaponSkinChromaDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkinChroma> list1 = new ArrayList<WeaponSkinChroma>( list.size() );
        for ( WeaponSkinChromaDTO weaponSkinChromaDTO : list ) {
            list1.add( weaponSkinChromaMapper.toWeaponSkinChroma( weaponSkinChromaDTO ) );
        }

        return list1;
    }

    protected List<WeaponSkinLevel> weaponSkinLevelDTOListToWeaponSkinLevelList(List<WeaponSkinLevelDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkinLevel> list1 = new ArrayList<WeaponSkinLevel>( list.size() );
        for ( WeaponSkinLevelDTO weaponSkinLevelDTO : list ) {
            list1.add( weaponSkinLevelMapper.toWeaponSkinLevel( weaponSkinLevelDTO ) );
        }

        return list1;
    }
}
