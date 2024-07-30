package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ResourceEntity;
import org.springframework.beans.BeanUtils;

public class ResourceDTO {

    private Long id;
    private String name;
    private String key;

    public ResourceDTO() {

    }

    public ResourceDTO(ResourceEntity resource) {
        BeanUtils.copyProperties(resource, this);
    }

    public ResourceDTO(Long id, String name, String key) {
        this.id = id;
        this.name = name;
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
