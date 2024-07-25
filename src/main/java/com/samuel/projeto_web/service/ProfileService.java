package com.samuel.projeto_web.service;

import com.samuel.projeto_web.dto.ProfileDTO;
import com.samuel.projeto_web.entity.ProfileEntity;
import com.samuel.projeto_web.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public List<ProfileDTO> listAll() {
        List<ProfileEntity> profileEntities = profileRepository.findAll();
        return profileEntities.stream().map(ProfileDTO::new).toList();
    }

    public void create(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        profileRepository.save(profileEntity);
    }

    public ProfileDTO update(ProfileDTO profileDTO) {
        ProfileEntity profileEntity = new ProfileEntity(profileDTO);
        return new ProfileDTO(profileRepository.save(profileEntity));
    }

    public void delete(Long id) {
        ProfileEntity profileEntity = profileRepository.findById(id).get();
        profileRepository.delete(profileEntity);
    }

    public ProfileDTO findById(Long id){
        return new ProfileDTO(profileRepository.findById(id).get());
    }

}
