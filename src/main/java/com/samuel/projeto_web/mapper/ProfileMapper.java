package com.samuel.projeto_web.mapper;

import com.samuel.projeto_web.dto.ProfileDTO;
import com.samuel.projeto_web.entity.ProfileEntity;

public class ProfileMapper {

    public static ProfileEntity dtoForEntity(ProfileDTO profileDTO) {
        return ProfileEntity.builder().id(profileDTO.getId()).description(profileDTO.getDescription()).build();
    }

    public static ProfileDTO entityForDto(ProfileEntity profileEntity) {
        return ProfileDTO.builder().id(profileEntity.getId()).description(profileEntity.getDescription()).build();
    }
}
