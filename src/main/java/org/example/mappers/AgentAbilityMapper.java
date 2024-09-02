package org.example.mappers;

import org.example.domain.entity.AgentAbility;
import org.example.rest.dto.AgentAbilityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class AgentAbilityMapper {

    public AgentAbilityDTO toAgentAbilityDTO(AgentAbility agentAbility) {
        if ( agentAbility == null ) {
            return null;
        }

        AgentAbilityDTO agentAbilityDTO = new AgentAbilityDTO();

        agentAbilityDTO.setSlot( agentAbility.getSlot() );
        agentAbilityDTO.setDisplayName( agentAbility.getDisplayName() );
        agentAbilityDTO.setDescription( agentAbility.getDescription() );
        agentAbilityDTO.setDisplayIcon( agentAbility.getDisplayIcon() );

        return agentAbilityDTO;
    }

    public AgentAbility toAgentAbility(AgentAbilityDTO agentAbilityDTO) {
        if ( agentAbilityDTO == null ) {
            return null;
        }

        AgentAbility agentAbility = new AgentAbility();

        agentAbility.setSlot( agentAbilityDTO.getSlot() );
        agentAbility.setDisplayName( agentAbilityDTO.getDisplayName() );
        agentAbility.setDescription( agentAbilityDTO.getDescription() );
        agentAbility.setDisplayIcon( agentAbilityDTO.getDisplayIcon() );

        return agentAbility;
    }
}
