package com.mypet.MyPet.repositories;

import com.mypet.MyPet.entities.AdoptionOfferEntity;
import com.mypet.MyPet.entities.PetEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdoptionOfferRepository extends CrudRepository<AdoptionOfferEntity , Long> {
    @Query("SELECT a FROM  AdoptionOfferEntity a WHERE a.status =false")
    List<AdoptionOfferEntity> findAllByAdoptionStatus();

    List<AdoptionOfferEntity> findAllByStatus(boolean status);
}