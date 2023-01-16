package com.mypet.MyPet.services;

import com.mypet.MyPet.dto.AdoptionOfferDto;
import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.entities.AdoptionOfferEntity;
import com.mypet.MyPet.entities.PetEntity;

import java.util.List;

public interface AdoptionService {
AdoptionOfferDto createAdoption(AdoptionOfferDto adoption, PetEntity findPet, PersonDto personDto);
List<AdoptionOfferEntity> getAll();
AdoptionOfferDto accept(PersonDto personDto, Long id);
}
