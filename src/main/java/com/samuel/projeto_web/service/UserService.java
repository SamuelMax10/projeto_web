package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.UserDTO;
import com.samuel.projeto_web.entity.UserEntity;
import com.samuel.projeto_web.mapper.UserMapper;
import com.samuel.projeto_web.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*read*/
    public List<UserDTO> listAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserMapper::entityForDto).toList();
    }

    public void create(UserDTO userDTO) {
        UserEntity userEntity = UserMapper.dtoForEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = UserMapper.dtoForEntity(userDTO);
        return UserMapper.entityForDto(userRepository.save(userEntity));
    }

    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    public UserDTO findById(Long id) {
        return UserMapper.entityForDto(userRepository.findById(id).get());
    }
}
