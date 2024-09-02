package org.example.mappers;

import org.example.domain.entity.WeaponShopDataGridPosition;
import org.example.rest.dto.WeaponShopDataGridPositionDTO;
import org.springframework.stereotype.Component;

@Component
public class WeaponShopDataGridPositionMapper {

    public WeaponShopDataGridPositionDTO toWeaponShopDataGridPositionDTO(WeaponShopDataGridPosition weaponShopDataGridPosition) {
        if ( weaponShopDataGridPosition == null ) {
            return null;
        }

        WeaponShopDataGridPositionDTO weaponShopDataGridPositionDTO = new WeaponShopDataGridPositionDTO();

        weaponShopDataGridPositionDTO.setId( weaponShopDataGridPosition.getId() );
        weaponShopDataGridPositionDTO.setRow( weaponShopDataGridPosition.getRow() );
        weaponShopDataGridPositionDTO.setColumn( weaponShopDataGridPosition.getColumn() );

        return weaponShopDataGridPositionDTO;
    }

    public WeaponShopDataGridPosition toWeaponShopDataGridPosition(WeaponShopDataGridPositionDTO weaponShopDataGridPositionDTO) {
        if ( weaponShopDataGridPositionDTO == null ) {
            return null;
        }

        WeaponShopDataGridPosition weaponShopDataGridPosition = new WeaponShopDataGridPosition();

        weaponShopDataGridPosition.setRow( weaponShopDataGridPositionDTO.getRow() );
        weaponShopDataGridPosition.setColumn( weaponShopDataGridPositionDTO.getColumn() );

        return weaponShopDataGridPosition;
    }
}