package com.mypet.MyPet.services;

import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PetEntity;

public interface PetService {

PetDto createPet(PetDto petDto);

PetDto updatePet(PetDto petDto);

void deletePet(String petId);

PetDto findPetById(String petId);


}

