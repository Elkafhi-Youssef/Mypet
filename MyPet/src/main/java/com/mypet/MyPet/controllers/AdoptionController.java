package com.mypet.MyPet.controllers;

import com.mypet.MyPet.dto.AdoptionOfferDto;
import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.requests.AdoptionOfferRequest;
import com.mypet.MyPet.responses.AdoptionOfferResponse;
import com.mypet.MyPet.responses.PetResponse;
import com.mypet.MyPet.services.AdoptionService;
import com.mypet.MyPet.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/adoption")
public class AdoptionController {
    @Autowired
    AdoptionService service;
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity<AdoptionOfferResponse> createAdoption(@RequestBody AdoptionOfferRequest adoptionRequest, Principal user ){
        PersonDto personDto  = personService.getUser(user.getName());
        ModelMapper modelMapper = new ModelMapper();
        AdoptionOfferDto adoptionDto = modelMapper.map(adoptionRequest, AdoptionOfferDto.class);
        adoptionDto.setPerson(personDto);
        AdoptionOfferDto createAdoption = service.createAdoption(adoptionDto);
        AdoptionOfferResponse adoptionOfferResponse = new AdoptionOfferResponse();
        return new ResponseEntity<AdoptionOfferResponse>(modelMapper.map(createAdoption, AdoptionOfferResponse.class), HttpStatus.CREATED);
    }
}
