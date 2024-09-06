package org.example.rest.controllers;


import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.rest.dto.AgentDTO;
import org.example.services.AgentService;
import org.example.services.imp.AgentServiceImpl;
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
@RequestMapping("/api/agents")
@RequiredArgsConstructor
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgentDTO save(@Valid @RequestBody AgentDTO agent) {
        agent.setDescription(HtmlSanitizerUtil.sanitizeHtml(agent.getDescription()));
        return agentService.save(agent);
    }

    @PutMapping("/{id}")
    public AgentDTO update(@PathVariable Long id, @RequestBody AgentDTO agent) throws NotFoundException {
        agent.setId(id);
        return agentService.update(agent);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws NotFoundException {
        agentService.delete(id);
    }

    @GetMapping("/{id}")
    public AgentDTO findById(@PathVariable Long id) throws NotFoundException {
        return agentService.findById(id);
    }

    @GetMapping
    public List<AgentDTO> findAll() {
        return agentService.findAll();
    }
}