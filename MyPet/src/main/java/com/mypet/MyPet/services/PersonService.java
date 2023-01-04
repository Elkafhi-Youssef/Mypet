package com.mypet.MyPet.services;

import com.mypet.MyPet.dto.PersonDto;
import com.mypet.MyPet.entities.PersonEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface PersonService extends UserDetailsService {

    PersonDto createUser(PersonDto user);

    PersonEntity getUser(String email);

    PersonEntity getUserByUserId(String userId);

    PersonEntity updateUser(String id, PersonEntity userDto);

    void deleteUser(String userId);

    List<PersonEntity> getUsers(int page, int limit, String search, int status);
    PersonEntity findUserByEmail(String email) throws InvocationTargetException, IllegalAccessException;
}
