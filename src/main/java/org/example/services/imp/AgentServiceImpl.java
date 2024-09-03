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
import org.example.services.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        String path = ImageUtils.saveBase64Image(agent.getFile(), agent.getDisplayName());
        agentOrm.setAssetPath(path);
        agentRepository.save(agentOrm);
        return agentMapper.toAgentDTO(agentOrm);
    }

    @Override
    @CacheEvict(value = "agents", allEntries = true)
    public AgentDTO update(AgentDTO agent) throws NotFoundException {
        if (agent.getId() != null) {
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
