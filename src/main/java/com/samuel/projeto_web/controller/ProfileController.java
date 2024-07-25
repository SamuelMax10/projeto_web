package com.samuel.projeto_web.controller;

import com.samuel.projeto_web.dto.ProfileDTO;
import com.samuel.projeto_web.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {


    private ProfileService profileService;

    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    @GetMapping
    public List<ProfileDTO> findAll(){
        return profileService.listAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProfileDTO> findById(@PathVariable Long id){
        ProfileDTO profileDTO = profileService.findById(id);
        return ResponseEntity.ok().body(profileDTO);
    }

    @PostMapping
    public void insert(@RequestBody ProfileDTO profileDTO){
        profileService.create(profileDTO);
    }

    @PutMapping
    public ProfileDTO update(@RequestBody ProfileDTO profileDTO){
        return profileService.update(profileDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        profileService.delete(id);
    }
}
