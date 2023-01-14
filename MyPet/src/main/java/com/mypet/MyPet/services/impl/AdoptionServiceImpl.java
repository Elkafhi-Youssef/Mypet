package com.mypet.MyPet.services.impl;

import com.mypet.MyPet.dto.AdoptionOfferDto;
import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.entities.AdoptionOfferEntity;
import com.mypet.MyPet.entities.PersonEntity;
import com.mypet.MyPet.repositories.AdoptionOfferRepository;
import com.mypet.MyPet.services.AdoptionService;
import com.mypet.MyPet.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionServiceImpl implements AdoptionService {
    @Autowired
    AdoptionOfferRepository adoptionOfferRepository;
    @Autowired
    Utils util;
    @Override
    public AdoptionOfferDto createAdoption(AdoptionOfferDto adoption) {
        ModelMapper modelMapper = new ModelMapper();

        AdoptionOfferEntity adoptionOfferEntity = modelMapper.map(adoption, AdoptionOfferEntity.class);
        adoptionOfferEntity.setAdoptionId(util.generateStringId(32));
        AdoptionOfferEntity newAdoption = adoptionOfferRepository.save(adoptionOfferEntity);
        AdoptionOfferDto newAdoptionDto = modelMapper.map(newAdoption, AdoptionOfferDto.class);
        return newAdoptionDto;
    }
}
