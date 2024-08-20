package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.ProfileDTO;
import com.samuel.projeto_web.entity.ProfileEntity;
import com.samuel.projeto_web.mapper.ProfileMapper;
import com.samuel.projeto_web.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public List<ProfileDTO> listAll() {
        List<ProfileEntity> profileEntities = profileRepository.findAll();
        return profileEntities.stream().map(ProfileMapper::entityForDto).toList();
    }

    public void create(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = ProfileMapper.dtoForEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    public ProfileDTO update(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = ProfileMapper.dtoForEntity(profileDTO);
        return ProfileMapper.entityForDto(profileRepository.save(profileEntity));
    }

    public void delete(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }

    public ProfileDTO findById(Long id) {
        return ProfileMapper.entityForDto(profileRepository.findById(id).get());
    }
}
