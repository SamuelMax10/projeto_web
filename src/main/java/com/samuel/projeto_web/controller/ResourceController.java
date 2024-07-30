package com.samuel.projeto_web.controller;

import com.samuel.projeto_web.dto.ResourceDTO;
import com.samuel.projeto_web.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/resources")
public class ResourceController {

    private ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping
    public List<ResourceDTO> findAll() {
        return resourceService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResourceDTO> findById(@PathVariable Long id) {
        ResourceDTO resourceDTO = resourceService.findById(id);
        return ResponseEntity.ok().body(resourceDTO);
    }

    @PostMapping
    public void insert(@RequestBody ResourceDTO resourceDTO) {
        resourceService.create(resourceDTO);
    }

    @PutMapping
    public ResourceDTO update(@RequestBody ResourceDTO resourceDTO) {
        return resourceService.update(resourceDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        resourceService.delete(id);
    }
}
