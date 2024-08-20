package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.UserEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String login;

    private String password;

    private String email;

//    public UserDTO(UserEntity user) {
//        BeanUtils.copyProperties(user, this);
//    }
}


