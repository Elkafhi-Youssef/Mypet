package com.mypet.MyPet.responses;

import lombok.Data;

@Data
public class AdoptionOfferResponse {
    private String title;
    private String description;
    private String city;
    private String numberDays;
    private String price;
    private  Boolean status;
    private PersonResponse person;

}
