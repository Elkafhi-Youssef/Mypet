package com.mypet.MyPet.controllers;

import com.mypet.MyPet.dto.AdoptionOfferDto;
import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PetEntity;
import com.mypet.MyPet.requests.AdoptionOfferRequest;
import com.mypet.MyPet.responses.AdoptionOfferResponse;
import com.mypet.MyPet.responses.DataResponse;
import com.mypet.MyPet.responses.PetResponse;
import com.mypet.MyPet.responses.Response;
import com.mypet.MyPet.services.AdoptionService;
import com.mypet.MyPet.services.PersonService;
import com.mypet.MyPet.services.PetService;
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
    @Autowired
    PetService petService;

    @PostMapping
    public ResponseEntity<Response> createAdoption(@RequestBody AdoptionOfferRequest adoptionRequest, Principal user ){
        ModelMapper modelMapper = new ModelMapper();
        System.out.println(" try to get the id "+adoptionRequest.getPetId());
        PetEntity findPet = petService.findPetById(adoptionRequest.getPetId());
        System.out.println("the pet that we find "+findPet.toString());
        PersonDto personDto  = personService.getUser(user.getName());
        AdoptionOfferDto adoptionDto = modelMapper.map(adoptionRequest, AdoptionOfferDto.class);
        adoptionDto.setPerson(personDto);
        adoptionDto.setPet(findPet);
        AdoptionOfferDto createAdoption = service.createAdoption(adoptionDto);
        return ResponseEntity.ok(new DataResponse("New adoption created successfully", 201, modelMapper.map(createAdoption, AdoptionOfferResponse.class)));
    }

}
