package com.mypet.MyPet.services.impl;

import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.entities.PersonEntity;
import com.mypet.MyPet.exceptions.ErrorMessages;
import com.mypet.MyPet.exceptions.UserException;
import com.mypet.MyPet.repositories.PersonRepository;
import com.mypet.MyPet.services.PersonService;
import com.mypet.MyPet.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils util;
    @Override
    public PersonDto createUser(PersonDto user) {
        PersonEntity checkUser = personRepository.findByEmail(user.getEmail());

        if(checkUser != null) throw new RuntimeException("User Alrady Exists !");

        ModelMapper modelMapper = new ModelMapper();

        PersonEntity personEntity = modelMapper.map(user, PersonEntity.class);


        personEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        personEntity.setPersonId(util.generateStringId(32));

        PersonEntity newUser = personRepository.save(personEntity);

        PersonDto personDto =  modelMapper.map(newUser, PersonDto.class);
        return personDto;
    }

    @Override
    public PersonDto getUser(String email) {
        PersonEntity checkUser = personRepository.findByEmail(email);
        ModelMapper modelMapper = new ModelMapper();
        PersonDto person = modelMapper.map(checkUser, PersonDto.class);
        return person;
    }

    @Override
    public PersonEntity getUserByUserId(String userId) {
        return null;
    }

    @Override
    public PersonEntity updateUser(String id, PersonEntity userDto) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public List<PersonEntity> getUsers(int page, int limit, String search, int status) {
        return null;
    }

    @Override
    public PersonEntity findUserByEmail(String email) throws Exception {
        PersonEntity personEntity = new PersonEntity();
        personEntity =  personRepository.findByEmail(email);
//        if (personEntity == null) throw new UsernameNotFoundException("email not found");
        if (personEntity == null)  throw new UserException(ErrorMessages.THE_USER_DONT_EXIST.getErrormessage());
        return personEntity;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
