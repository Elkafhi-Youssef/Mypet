package com.mypet.MyPet.dto;

import lombok.Data;

@Data
public class AdoptionOfferDto {
    private String adoptionId;
    private String title;
    private String description;
    private String city;
    private String numberDays;
    private String price;
    private  Boolean status;
    private PersonDto person;
}