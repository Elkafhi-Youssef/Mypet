package com.mypet.MyPet.controllers;

import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PersonEntity;
import com.mypet.MyPet.requests.PetRequest;
import com.mypet.MyPet.responses.PetResponse;
import com.mypet.MyPet.services.PersonService;
import com.mypet.MyPet.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    PersonService personService;

    @PostMapping( consumes={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PetResponse> createPet(@RequestBody PetRequest pet , Principal user) {
//        System.out.println(pet.toString());
        System.out.println("try to get data"+user.getName());
        PersonDto personDto  = personService.getUser(user.getName());
        System.out.println("user who log in "+ personDto.toString());
        ModelMapper modelMapper = new ModelMapper();
        PetDto petDto = modelMapper.map(pet, PetDto.class);
        petDto.setPerson(personDto);
        PetDto newPet  = petService.createPet(petDto);
        return new ResponseEntity<PetResponse>(modelMapper.map(newPet, PetResponse.class), HttpStatus.CREATED);
    }
}
