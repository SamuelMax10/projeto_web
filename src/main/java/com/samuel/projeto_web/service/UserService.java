package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.UserDTO;
import com.samuel.projeto_web.entity.UserEntity;
import com.samuel.projeto_web.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
       this.userRepository = userRepository;
    }
    /*read*/
    public List<UserDTO> listAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserDTO::new).toList();
    }

    public void create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        userRepository.delete(userEntity);
    }

    public UserDTO findById(Long id) {
        return new UserDTO(userRepository.findById(id).get());
    }
}
