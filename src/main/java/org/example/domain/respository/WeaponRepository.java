package org.example.domain.respository;

import org.example.domain.entity.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
