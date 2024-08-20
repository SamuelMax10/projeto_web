package com.samuel.projeto_web.entity;

import com.samuel.projeto_web.dto.ProfileDTO;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "SM_PROFILE")
@Builder
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String description;

    public ProfileEntity(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileEntity profile = (ProfileEntity) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
