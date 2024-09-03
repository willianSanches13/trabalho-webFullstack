package org.example.services.imp;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.domain.entity.Agent;
import org.example.domain.respository.AgentRepository;
import org.example.mappers.AgentMapper;
import org.example.rest.dto.AgentDTO;
import org.example.services.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AgentMapper agentMapper;


    @Override
    @CacheEvict(value = "agents", allEntries = true)
    public AgentDTO save(AgentDTO agent) {
        Agent agentOrm = agentMapper.toAgent(agent);
        agentRepository.save(agentOrm);
        return agentMapper.toAgentDTO(agentOrm);
    }

    @Override
    @CacheEvict(value = "agents", allEntries = true)
    public AgentDTO update(AgentDTO agent) throws NotFoundException {
        if (agent != null) {
            Agent existingAgent = agentRepository.findById(agent.getId())
                    .orElseThrow(() -> new NotFoundException("Agent not found"));
            agentMapper.updateAgentFromDTO(agent, existingAgent);
            agentRepository.save(existingAgent);
            return agentMapper.toAgentDTO(existingAgent);
        }else{
            save(agent);
        }
        return agent;
    }

    @Override
    @CacheEvict(value = "agents", allEntries = true)
    public void delete(Long id) throws NotFoundException {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agent not found"));
        agentRepository.delete(existingAgent);
    }

    @Override
    @Cacheable(value = "agents", key = "#id")
    public AgentDTO findById(Long id) throws NotFoundException {
        Agent existingAgent = agentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Agent not found"));
        return agentMapper.toAgentDTO(existingAgent);
    }

    @Override
    @CacheEvict(value = "agents", allEntries = true)
    public List<AgentDTO> findAll() {
        List<Agent> agents = agentRepository.findAll();
        return agents.stream()
                .map(agentMapper::toAgentDTO)
                .collect(Collectors.toList());
    }
}
