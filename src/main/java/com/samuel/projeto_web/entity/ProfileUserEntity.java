package com.samuel.projeto_web.entity;


import com.samuel.projeto_web.dto.ProfileUserDTO;
import com.samuel.projeto_web.mapper.ProfileMapper;
import com.samuel.projeto_web.mapper.UserMapper;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.beans.BeanUtils;

import java.security.PublicKey;
import java.util.Objects;

@Entity
@Table(name = "SM_PROFILE_USER")
@Builder
public class ProfileUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USER")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "ID_PROFILE")
    private ProfileEntity profile;

    public ProfileUserEntity() {

    }

    public ProfileUserEntity(Long id, UserEntity user, ProfileEntity profile) {
        this.id = id;
        this.user = user;
        this.profile = profile;
    }

    public ProfileUserEntity(ProfileUserDTO profileUserDTO) {
        BeanUtils.copyProperties(profileUserDTO, this);
        this.user = profileUserDTO.getUserDTO() != null ? UserMapper.dtoForEntity(profileUserDTO.getUserDTO()) : null;
        this.profile = profileUserDTO.getProfileDTO() != null ? ProfileMapper.dtoForEntity(profileUserDTO.getProfileDTO()) : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileUserEntity that = (ProfileUserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
