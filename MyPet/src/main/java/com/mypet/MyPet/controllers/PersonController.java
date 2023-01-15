package com.mypet.MyPet.controllers;

import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.exceptions.ErrorMessages;
import com.mypet.MyPet.exceptions.UserException;
import com.mypet.MyPet.requests.PersonRequest;
import com.mypet.MyPet.responses.DataResponse;
import com.mypet.MyPet.responses.PersonResponse;
import com.mypet.MyPet.responses.Response;
import com.mypet.MyPet.services.PersonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("/addPerson"

    )
    public ResponseEntity<Response> createUser(@RequestBody PersonRequest personRequest) throws Exception {

        if(personRequest.getFullName().isEmpty()){
          throw new UserException(ErrorMessages.MISSING_REQUIRED_FILED.getErrormessage());

        }

        //UserDto userDto = new UserDto();
        //BeanUtils.copyProperties(userRequest, userDto);
        ModelMapper modelMapper = new ModelMapper();
        PersonDto personDto = modelMapper.map(personRequest, PersonDto.class);
        PersonDto createUser = personService.createUser(personDto);
        PersonResponse pr= modelMapper.map(createUser, PersonResponse.class);
        return ResponseEntity.ok(new DataResponse("Offer created successfully", 201,pr ));


    }


}
