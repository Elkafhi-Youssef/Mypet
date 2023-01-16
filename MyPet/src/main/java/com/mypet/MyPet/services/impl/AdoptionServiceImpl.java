package com.mypet.MyPet.services.impl;

import com.mypet.MyPet.dto.AdoptionOfferDto;
import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.entities.AdoptionOfferEntity;
import com.mypet.MyPet.entities.PersonEntity;
import com.mypet.MyPet.entities.PetEntity;
import com.mypet.MyPet.repositories.AdoptionOfferRepository;
import com.mypet.MyPet.services.AdoptionService;
import com.mypet.MyPet.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdoptionServiceImpl implements AdoptionService {
    @Autowired
    AdoptionOfferRepository adoptionOfferRepository;
    @Autowired
    Utils util;
    @Override
    public AdoptionOfferDto createAdoption(AdoptionOfferDto adoption, PetEntity findPet,PersonDto personDto) {
        ModelMapper modelMapper = new ModelMapper();

        AdoptionOfferEntity adoptionOfferEntity = modelMapper.map(adoption, AdoptionOfferEntity.class);
        adoptionOfferEntity.setAdoptionId(util.generateStringId(32));
        adoptionOfferEntity.setPerson( modelMapper.map(personDto, PersonEntity.class));
        adoptionOfferEntity.setPet(findPet);
        AdoptionOfferEntity newAdoption = adoptionOfferRepository.save(adoptionOfferEntity);
        AdoptionOfferDto newAdoptionDto = modelMapper.map(newAdoption, AdoptionOfferDto.class);
        return newAdoptionDto;
    }
    @Override
    public List<AdoptionOfferEntity> getAll() {
        return (List<AdoptionOfferEntity>) adoptionOfferRepository.findAllByStatus(false);
    }

    @Override
    public AdoptionOfferDto accept(PersonDto personDto, Long id) {
        ModelMapper modelMapper = new ModelMapper();
        PersonEntity personEntity = modelMapper.map(personDto, PersonEntity.class);
        AdoptionOfferEntity findAdoption =adoptionOfferRepository.findById(id).orElseThrow(()-> new RuntimeException());
        findAdoption.setPersonaccepted(personEntity);
        findAdoption.setStatus(true);
        AdoptionOfferEntity saveAdoption =adoptionOfferRepository.save(findAdoption);
        return modelMapper.map(saveAdoption, AdoptionOfferDto.class);
    }
}
