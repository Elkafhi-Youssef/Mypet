package com.mypet.MyPet.repositories;

import com.mypet.MyPet.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity, Long> {

}
