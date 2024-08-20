package com.samuel.projeto_web.mapper;

import com.samuel.projeto_web.dto.UserDTO;
import com.samuel.projeto_web.entity.UserEntity;

public class UserMapper {

    public static UserEntity dtoForEntity(UserDTO userDTO) {
        return UserEntity.builder().id(userDTO.getId()).login(userDTO.getLogin()).email(userDTO.getEmail()).name(userDTO.getName()).build();
    }

    public static UserDTO entityForDto(UserEntity userEntity) {
        return UserDTO.builder().id(userEntity.getId()).login(userEntity.getLogin()).email(userEntity.getEmail()).name(userEntity.getName()).build();
    }
}
