package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ProfileEntity;
import org.springframework.beans.BeanUtils;

public class ProfileDTO {

    private Long id;

    private String description;

    public ProfileDTO(){

    }

    public ProfileDTO(ProfileEntity profileEntity) {
        BeanUtils.copyProperties(profileEntity, this);
    }

    public ProfileDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
