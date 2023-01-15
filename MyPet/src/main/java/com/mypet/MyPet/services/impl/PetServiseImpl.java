package com.mypet.MyPet.services.impl;

import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PetEntity;
import com.mypet.MyPet.repositories.PetRepository;
import com.mypet.MyPet.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiseImpl implements PetService {
    @Autowired
    PetRepository petRepository;
    @Override
    public PetDto createPet(PetDto petDto) {
        ModelMapper modelMapper = new ModelMapper();
        PetEntity petEntity = modelMapper.map(petDto, PetEntity.class);
        PetEntity result = petRepository.save(petEntity);
        return modelMapper.map(result, PetDto.class);
    }

    @Override
    public PetDto updatePet(PetDto petDto) {
        return null;
    }

    @Override
    public void deletePet(String petId) {

    }

    @Override
    public PetEntity findPetById(long petId) {
       Optional<PetEntity> findPet = petRepository.findById(petId);
        if(findPet.isPresent())
            return findPet.get();
        return null;
    }

    @Override
    public List<PetEntity> getAll(Long id) {
        return petRepository.findAllByUserId(id);
    }
}
