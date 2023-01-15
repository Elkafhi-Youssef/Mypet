package com.mypet.MyPet.services;

import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PetEntity;

import java.util.List;

public interface PetService {

PetDto createPet(PetDto petDto);

PetDto updatePet(PetDto petDto);

void deletePet(String petId);

PetEntity findPetById(long Id);

List<PetEntity> getAll(Long id);

}

