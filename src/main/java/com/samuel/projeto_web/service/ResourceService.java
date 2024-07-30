package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.ResourceDTO;
import com.samuel.projeto_web.entity.ResourceEntity;
import com.samuel.projeto_web.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private ResourceRepository resourceRepository;

    public ResourceService(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    public List<ResourceDTO> listAll(){
        List<ResourceEntity> resourceEntities = resourceRepository.findAll();
        return resourceEntities.stream().map(ResourceDTO::new).toList();
    }

    public void create(ResourceDTO resourceDTO){
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        resourceRepository.save(resourceEntity);
    }

    public ResourceDTO update(ResourceDTO resourceDTO){
        ResourceEntity resourceEntity = new ResourceEntity(resourceDTO);
        return new ResourceDTO (resourceRepository.save(resourceEntity));
    }

    public void delete(Long id){
        ResourceEntity resourceEntity = resourceRepository.findById(id).get();
        resourceRepository.delete(resourceEntity);
    }

    public ResourceDTO findById(Long id){
        return new ResourceDTO(resourceRepository.findById(id).get());
    }
}
