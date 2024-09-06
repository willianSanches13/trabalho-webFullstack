package org.example.mappers;

import org.example.domain.entity.Agent;
import org.example.domain.entity.AgentAbility;
import org.example.rest.dto.AgentAbilityDTO;
import org.example.rest.dto.AgentDTO;
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
public class AgentMapper {
    @Autowired
    private AgentRoleMapper agentRoleMapper;
    @Autowired
    private AgentAbilityMapper agentAbilityMapper;

    public AgentDTO toAgentDTO(Agent agent) {
        if ( agent == null ) {
            return null;
        }

        AgentDTO agentDTO = new AgentDTO();

        agentDTO.setId( agent.getId() );
        agentDTO.setDisplayName( agent.getDisplayName() );
        agentDTO.setDescription( agent.getDescription() );
        agentDTO.setDeveloperName( agent.getDeveloperName() );
        List<String> list = agent.getCharacterTags();
        if ( list != null ) {
            agentDTO.setCharacterTags( new ArrayList<String>( list ) );
        }
        agentDTO.setDisplayIcon( agent.getDisplayIcon() );
        agentDTO.setBustPortrait( agent.getBustPortrait() );
        agentDTO.setFullPortrait( agent.getFullPortrait() );
        agentDTO.setAssetPath( agent.getAssetPath() );
        agentDTO.setFullPortraitRightFacing( agent.isFullPortraitRightFacing() );
        agentDTO.setPlayableCharacter( agent.isPlayableCharacter() );
        agentDTO.setAvailableForTest( agent.isAvailableForTest() );
        agentDTO.setRole( agentRoleMapper.toAgentRoleDTO( agent.getRole() ) );
        agentDTO.setAbilities( agentAbilityListToAgentAbilityDTOList( agent.getAbilities() ) );

        return agentDTO;
    }

    public Agent toAgent(AgentDTO agentDTO) {
        if ( agentDTO == null ) {
            return null;
        }

        Agent agent = new Agent();

        agent.setDisplayName( agentDTO.getDisplayName() );
        agent.setDeveloperName( agentDTO.getDeveloperName() );
        List<String> list = agentDTO.getCharacterTags();
        if ( list != null ) {
            agent.setCharacterTags( new ArrayList<String>( list ) );
        }
        agent.setDisplayIcon( agentDTO.getDisplayIcon() );
        agent.setBustPortrait( agentDTO.getBustPortrait() );
        agent.setFullPortrait( agentDTO.getFullPortrait() );
        agent.setFullPortraitRightFacing( agentDTO.isFullPortraitRightFacing() );
        agent.setPlayableCharacter( agentDTO.isPlayableCharacter() );
        agent.setAvailableForTest( agentDTO.isAvailableForTest() );
        agent.setRole( agentRoleMapper.toAgentRole( agentDTO.getRole() ) );
        agent.setAbilities( agentAbilityDTOListToAgentAbilityList( agentDTO.getAbilities() ) );

        return agent;
    }

    public void updateAgentFromDTO(AgentDTO agentDTO, Agent agent) {
        if ( agentDTO == null ) {
            return;
        }

        agent.setId( agentDTO.getId() );
        agent.setDisplayName( agentDTO.getDisplayName() );
        agent.setDescription( agentDTO.getDescription() );
        agent.setDeveloperName( agentDTO.getDeveloperName() );
        if ( agent.getCharacterTags() != null ) {
            List<String> list = agentDTO.getCharacterTags();
            if ( list != null ) {
                agent.getCharacterTags().clear();
                agent.getCharacterTags().addAll( list );
            }
            else {
                agent.setCharacterTags( null );
            }
        }
        else {
            List<String> list = agentDTO.getCharacterTags();
            if ( list != null ) {
                agent.setCharacterTags( new ArrayList<String>( list ) );
            }
        }
        agent.setDisplayIcon( agentDTO.getDisplayIcon() );
        agent.setBustPortrait( agentDTO.getBustPortrait() );
        agent.setFullPortrait( agentDTO.getFullPortrait() );
        agent.setAssetPath( agentDTO.getAssetPath() );
        agent.setFullPortraitRightFacing( agentDTO.isFullPortraitRightFacing() );
        agent.setPlayableCharacter( agentDTO.isPlayableCharacter() );
        agent.setAvailableForTest( agentDTO.isAvailableForTest() );
        agent.setRole( agentRoleMapper.toAgentRole( agentDTO.getRole() ) );
        if ( agent.getAbilities() != null ) {
            List<AgentAbility> list1 = agentAbilityDTOListToAgentAbilityList( agentDTO.getAbilities() );
            if ( list1 != null ) {
                agent.getAbilities().clear();
                agent.getAbilities().addAll( list1 );
            }
            else {
                agent.setAbilities( null );
            }
        }
        else {
            List<AgentAbility> list1 = agentAbilityDTOListToAgentAbilityList( agentDTO.getAbilities() );
            if ( list1 != null ) {
                agent.setAbilities( list1 );
            }
        }
    }

    protected List<AgentAbilityDTO> agentAbilityListToAgentAbilityDTOList(List<AgentAbility> list) {
        if ( list == null ) {
            return null;
        }

        List<AgentAbilityDTO> list1 = new ArrayList<AgentAbilityDTO>( list.size() );
        for ( AgentAbility agentAbility : list ) {
            list1.add( agentAbilityMapper.toAgentAbilityDTO( agentAbility ) );
        }

        return list1;
    }

    public List<AgentAbility> agentAbilityDTOListToAgentAbilityList(List<AgentAbilityDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<AgentAbility> list1 = new ArrayList<AgentAbility>( list.size() );
        for ( AgentAbilityDTO agentAbilityDTO : list ) {
            list1.add( agentAbilityMapper.toAgentAbility( agentAbilityDTO ) );
        }

        return list1;
    }
}