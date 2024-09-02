package org.example.mappers;

import org.example.domain.entity.Weapon;
import org.example.domain.entity.WeaponSkin;
import org.example.rest.dto.WeaponDTO;
import org.example.rest.dto.WeaponSkinDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponMapper {

    @Autowired
    private WeaponStatsMapper weaponStatsMapper;

    @Autowired
    private WeaponSkinMapper weaponSkinMapper;

    public WeaponDTO toWeaponDTO(Weapon weapon) {
        if ( weapon == null ) {
            return null;
        }

        WeaponDTO weaponDTO = new WeaponDTO();

        weaponDTO.setId( weapon.getId() );
        weaponDTO.setDisplayName( weapon.getDisplayName() );
        weaponDTO.setCategory( weapon.getCategory() );
        weaponDTO.setDefaultSkinUuid( weapon.getDefaultSkinUuid() );
        weaponDTO.setKillStreamIcon( weapon.getKillStreamIcon() );
        weaponDTO.setAssetPath( weapon.getAssetPath() );
        weaponDTO.setWeaponStats( weaponStatsMapper.toWeaponStatsDTO( weapon.getWeaponStats() ) );
        weaponDTO.setSkins( weaponSkinListToWeaponSkinDTOList( weapon.getSkins() ) );

        return weaponDTO;
    }

    public Weapon toWeapon(WeaponDTO weaponDTO) {
        if ( weaponDTO == null ) {
            return null;
        }

        Weapon weapon = new Weapon();

        weapon.setDisplayName( weaponDTO.getDisplayName() );
        weapon.setCategory( weaponDTO.getCategory() );
        weapon.setDefaultSkinUuid( weaponDTO.getDefaultSkinUuid() );
        weapon.setKillStreamIcon( weaponDTO.getKillStreamIcon() );
        weapon.setAssetPath( weaponDTO.getAssetPath() );
        weapon.setWeaponStats( weaponStatsMapper.toWeaponStats( weaponDTO.getWeaponStats() ) );
        weapon.setSkins( weaponSkinDTOListToWeaponSkinList( weaponDTO.getSkins() ) );

        return weapon;
    }

    public void updateWeaponFromDTO(WeaponDTO weaponDTO, Weapon weapon) {
        if ( weaponDTO == null ) {
            return;
        }

        weapon.setId( weaponDTO.getId() );
        weapon.setDisplayName( weaponDTO.getDisplayName() );
        weapon.setCategory( weaponDTO.getCategory() );
        weapon.setDefaultSkinUuid( weaponDTO.getDefaultSkinUuid() );
        weapon.setKillStreamIcon( weaponDTO.getKillStreamIcon() );
        weapon.setAssetPath( weaponDTO.getAssetPath() );
        weapon.setWeaponStats( weaponStatsMapper.toWeaponStats( weaponDTO.getWeaponStats() ) );
        if ( weapon.getSkins() != null ) {
            List<WeaponSkin> list = weaponSkinDTOListToWeaponSkinList( weaponDTO.getSkins() );
            if ( list != null ) {
                weapon.getSkins().clear();
                weapon.getSkins().addAll( list );
            }
            else {
                weapon.setSkins( null );
            }
        }
        else {
            List<WeaponSkin> list = weaponSkinDTOListToWeaponSkinList( weaponDTO.getSkins() );
            if ( list != null ) {
                weapon.setSkins( list );
            }
        }
    }

    public List<WeaponSkinDTO> weaponSkinListToWeaponSkinDTOList(List<WeaponSkin> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkinDTO> list1 = new ArrayList<WeaponSkinDTO>( list.size() );
        for ( WeaponSkin weaponSkin : list ) {
            list1.add( weaponSkinMapper.toWeaponSkinDTO( weaponSkin ) );
        }

        return list1;
    }

    public List<WeaponSkin> weaponSkinDTOListToWeaponSkinList(List<WeaponSkinDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<WeaponSkin> list1 = new ArrayList<WeaponSkin>( list.size() );
        for ( WeaponSkinDTO weaponSkinDTO : list ) {
            list1.add( weaponSkinMapper.toWeaponSkin( weaponSkinDTO ) );
        }

        return list1;
    }
}
