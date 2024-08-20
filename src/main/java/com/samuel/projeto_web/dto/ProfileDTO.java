package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ProfileEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {

    private Long id;

    private String description;
}
