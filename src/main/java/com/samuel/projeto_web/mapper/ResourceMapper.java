package com.samuel.projeto_web.mapper;

import com.samuel.projeto_web.dto.ResourceDTO;
import com.samuel.projeto_web.entity.ResourceEntity;

public class ResourceMapper {

    public static ResourceEntity dtoForEntity(ResourceDTO resourceDTO) {
        return ResourceEntity.builder().id(resourceDTO.getId()).name(resourceDTO.getName()).key(resourceDTO.getKey()).build();

    }

    public static ResourceDTO entityForDto(ResourceEntity resourceEntity) {
        return ResourceDTO.builder().id(resourceEntity.getId()).name(resourceEntity.getName()).key(resourceEntity.getKey()).build();
    }
}
