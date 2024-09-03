package org.example.services.imp;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.domain.entity.Weapon;
import org.example.domain.respository.WeaponRepository;
import org.example.mappers.WeaponMapper;
import org.example.rest.dto.WeaponDTO;
import org.example.services.WeaponService;
import org.example.services.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class WeaponServiceImpl implements WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private WeaponMapper weaponMapper;

    @Override
    @CacheEvict(value = "weapons", allEntries = true)
    public WeaponDTO save(WeaponDTO weapon) {
        Weapon weaponOrm = weaponMapper.toWeapon(weapon);
        String path = ImageUtils.saveBase64Image(weapon.getFile(), weapon.getDisplayName());
        weaponOrm.setAssetPath(path);
        weaponRepository.save(weaponOrm);
        return weaponMapper.toWeaponDTO(weaponOrm);
    }

    @Override
    @CacheEvict(value = "weapons", allEntries = true)
    public WeaponDTO update(WeaponDTO weapon) throws NotFoundException {
        if (weapon != null) {
            Weapon existingWeapon = weaponRepository.findById(weapon.getId())
                    .orElseThrow(() -> new NotFoundException("Weapon not found"));
            weaponMapper.updateWeaponFromDTO(weapon, existingWeapon);
            weaponRepository.save(existingWeapon);
            return weaponMapper.toWeaponDTO(existingWeapon);
        } else {
            save(weapon);
        }
        return weapon;
    }

    @Override
    @CacheEvict(value = "weapons", allEntries = true)
    public void delete(Long id) throws NotFoundException {
        Weapon existingWeapon = weaponRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Weapon not found"));
        weaponRepository.delete(existingWeapon);
    }

    @Override
    @Cacheable(value = "weapons", key = "#id")
    public WeaponDTO findById(Long id) throws NotFoundException {
        Weapon existingWeapon = weaponRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Weapon not found"));
        return weaponMapper.toWeaponDTO(existingWeapon);
    }

    @Override
    @Cacheable(value = "weapons")
    public List<WeaponDTO> findAll() {
        List<Weapon> weapons = weaponRepository.findAll();
        return weapons.stream()
                .map(weaponMapper::toWeaponDTO)
                .collect(Collectors.toList());
    }
}