package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ProfileUserEntity;
import com.samuel.projeto_web.mapper.ProfileMapper;
import com.samuel.projeto_web.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileUserDTO {

    private Long id;

    private UserDTO userDTO;

    private ProfileDTO profileDTO;

    public ProfileUserDTO(ProfileUserEntity profileUserEntity) {
        BeanUtils.copyProperties(profileUserEntity, this);
        this.userDTO = profileUserEntity.getUser() != null ? UserMapper.entityForDto(profileUserEntity.getUser()) : null;
        this.profileDTO = profileUserEntity.getProfile() != null ? ProfileMapper.entityForDto(profileUserEntity.getProfile()) : null;
    }
}
