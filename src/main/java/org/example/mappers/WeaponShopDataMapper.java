package org.example.mappers;

import org.example.domain.entity.WeaponShopData;
import org.example.rest.dto.WeaponShopDataDTO;
import org.example.rest.dto.WeaponShopDataGridPositionDTO;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeaponShopDataMapper {

    @Autowired
    private WeaponShopDataGridPositionMapper weaponShopDataGridPositionMapper;

    public WeaponShopDataDTO toWeaponShopDataDTO(WeaponShopData weaponShopData) {
        if ( weaponShopData == null ) {
            return null;
        }

        WeaponShopDataDTO weaponShopDataDTO = new WeaponShopDataDTO();

        weaponShopDataDTO.setId( weaponShopData.getId() );
        weaponShopDataDTO.setCost( weaponShopData.getCost() );
        weaponShopDataDTO.setCategory( weaponShopData.getCategory() );
        weaponShopDataDTO.setCategoryText( weaponShopData.getCategoryText() );
        weaponShopDataDTO.setGridPosition( weaponShopDataGridPositionMapper.toWeaponShopDataGridPositionDTO( weaponShopData.getGridPosition() ) );
        weaponShopDataDTO.setImage( weaponShopData.getImage() );
        weaponShopDataDTO.setNewImage( weaponShopData.getNewImage() );
        weaponShopDataDTO.setNewImage2( weaponShopData.getNewImage2() );
        weaponShopDataDTO.setAssetPath( weaponShopData.getAssetPath() );

        return weaponShopDataDTO;
    }

    public WeaponShopData toWeaponShopData(WeaponShopDataDTO weaponShopDataDTO) {
        if ( weaponShopDataDTO == null ) {
            return null;
        }

        WeaponShopData weaponShopData = new WeaponShopData();

        weaponShopData.setCost( weaponShopDataDTO.getCost() );
        weaponShopData.setCategory( weaponShopDataDTO.getCategory() );
        weaponShopData.setCategoryText( weaponShopDataDTO.getCategoryText() );
        weaponShopData.setGridPosition( weaponShopDataGridPositionMapper.toWeaponShopDataGridPosition( weaponShopDataDTO.getGridPosition() ) );
        weaponShopData.setImage( weaponShopDataDTO.getImage() );
        weaponShopData.setNewImage( weaponShopDataDTO.getNewImage() );
        weaponShopData.setNewImage2( weaponShopDataDTO.getNewImage2() );
        weaponShopData.setAssetPath( weaponShopDataDTO.getAssetPath() );

        return weaponShopData;
    }
}