package com.samuel.projeto_web.dto;

import com.samuel.projeto_web.entity.ResourceEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceDTO {

    private Long id;
    private String name;
    private String key;
}

