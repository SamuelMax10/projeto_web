package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ProfileUserEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class ProfileUserDTO {

    private Long id;

    private UserDTO userDTO;

    private ProfileDTO profileDTO;

    public ProfileUserDTO(ProfileUserEntity profileUserEntity) {
        BeanUtils.copyProperties(profileUserEntity, this);
        this.userDTO = profileUserEntity.getUser() != null ? new UserDTO(profileUserEntity.getUser()) : null;
        this.profileDTO = profileUserEntity.getProfile() != null ? new ProfileDTO(profileUserEntity.getProfile()) : null;
    }
}
