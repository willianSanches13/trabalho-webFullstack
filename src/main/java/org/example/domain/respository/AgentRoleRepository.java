package org.example.domain.respository;

import org.example.domain.entity.AgentAbility;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgentRoleRepository extends JpaRepository<AgentAbility, Integer> {
}
