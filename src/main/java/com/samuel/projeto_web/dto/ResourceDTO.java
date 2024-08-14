package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ResourceEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ResourceDTO {

    private Long id;
    private String name;
    private String key;

    public ResourceDTO(ResourceEntity resource) {
        BeanUtils.copyProperties(resource, this);
    }
}

