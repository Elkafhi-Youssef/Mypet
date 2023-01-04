package com.mypet.MyPet.repositories;

import com.mypet.MyPet.entities.PersonEntity;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<PersonEntity, Long> {
   PersonEntity findByEmail(String email);
}
