package com.mypet.MyPet.controllers;

import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.dto.PetDto;
import com.mypet.MyPet.entities.PersonEntity;
import com.mypet.MyPet.requests.PetRequest;
import com.mypet.MyPet.responses.DataResponse;
import com.mypet.MyPet.responses.PetResponse;
import com.mypet.MyPet.responses.Response;
import com.mypet.MyPet.services.PersonService;
import com.mypet.MyPet.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    PetService petService;

    @Autowired
    PersonService personService;
    @PostMapping()
    public ResponseEntity<Response> createPet(@RequestBody PetRequest pet , Principal user) {
        PersonDto personDto  = personService.getUser(user.getName());
        ModelMapper modelMapper = new ModelMapper();
        PetDto petDto = modelMapper.map(pet, PetDto.class);
        petDto.setPerson(personDto);
        PetDto newPet  = petService.createPet(petDto);
        return ResponseEntity.ok(new DataResponse("New Pet created successfully", 201, newPet));
    }
    @GetMapping("/all")
    public ResponseEntity<Response> getAllJobTitles( Principal user){
        PersonDto personDto  = personService.getUser(user.getName());
        Long id = personDto.getId();
        return ResponseEntity.ok(new DataResponse("Job titles list", 200,petService.getAll(id)));
    }
}
