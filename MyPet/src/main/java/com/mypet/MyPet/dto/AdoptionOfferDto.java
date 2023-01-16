package com.mypet.MyPet.dto;

import com.mypet.MyPet.entities.PetEntity;
import lombok.Data;

@Data
public class AdoptionOfferDto {
    private String adoptionId;
    private String description;
    private String city;
    private String numberDays;
    private String price;
    private  Boolean status = Boolean.FALSE;
    private PersonDto person;
    private PetEntity pet;
    private PersonKeeperDto personaccepted;
}