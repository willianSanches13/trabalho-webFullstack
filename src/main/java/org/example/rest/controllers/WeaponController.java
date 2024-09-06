package org.example.rest.controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.rest.dto.WeaponDTO;
import org.example.services.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/weapons")
@RequiredArgsConstructor
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public WeaponDTO save(@Valid @RequestBody WeaponDTO weapon) {
        return weaponService.save(weapon);
    }

    @PutMapping("/{id}")
    public WeaponDTO update(@PathVariable Long id, @RequestBody WeaponDTO weapon) throws NotFoundException {
        weapon.setId(id);
        return weaponService.update(weapon);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException {
        weaponService.delete(id);
    }

    @GetMapping("/{id}")
    public WeaponDTO findById(@PathVariable Long id) throws NotFoundException {
        return weaponService.findById(id);
    }

    @GetMapping
    public List<WeaponDTO> findAll() {
        return weaponService.findAll();
    }
}