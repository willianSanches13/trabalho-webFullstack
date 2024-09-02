package org.example.mappers;

import org.example.domain.entity.AgentRole;
import org.example.rest.dto.AgentRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public class AgentRoleMapper {

    public AgentRoleDTO toAgentRoleDTO(AgentRole agentRole) {
        if ( agentRole == null ) {
            return null;
        }

        AgentRoleDTO agentRoleDTO = new AgentRoleDTO();

        agentRoleDTO.setId( agentRole.getId() );
        agentRoleDTO.setDisplayName( agentRole.getDisplayName() );
        agentRoleDTO.setDescription( agentRole.getDescription() );
        agentRoleDTO.setDisplayIcon( agentRole.getDisplayIcon() );
        agentRoleDTO.setAssetPath( agentRole.getAssetPath() );

        return agentRoleDTO;
    }

    public AgentRole toAgentRole(AgentRoleDTO agentRoleDTO) {
        if ( agentRoleDTO == null ) {
            return null;
        }

        AgentRole agentRole = new AgentRole();

        agentRole.setDisplayName( agentRoleDTO.getDisplayName() );
        agentRole.setDescription( agentRoleDTO.getDescription() );
        agentRole.setDisplayIcon( agentRoleDTO.getDisplayIcon() );
        agentRole.setAssetPath( agentRoleDTO.getAssetPath() );

        return agentRole;
    }
}
