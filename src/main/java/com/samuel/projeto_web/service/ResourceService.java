package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.ResourceDTO;
import com.samuel.projeto_web.entity.ResourceEntity;
import com.samuel.projeto_web.mapper.ResourceMapper;
import com.samuel.projeto_web.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<ResourceDTO> listAll() {
        List<ResourceEntity> resourceEntities = resourceRepository.findAll();
        return resourceEntities.stream().map(ResourceMapper::entityForDto).toList();
    }

    public void create(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = ResourceMapper.dtoForEntity(resourceDTO);
        resourceRepository.save(resourceEntity);
    }

    public ResourceDTO update(ResourceDTO resourceDTO) {
        ResourceEntity resourceEntity = ResourceMapper.dtoForEntity(resourceDTO);
        return ResourceMapper.entityForDto(resourceRepository.save(resourceEntity));
    }

    public void delete(Long id) {
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

    public ResourceDTO findById(Long id) {
        return ResourceMapper.entityForDto(resourceRepository.findById(id).get());
    }
}
