package com.mypet.MyPet.requests;

import lombok.Data;

@Data
public class AdoptionOfferRequest {

    private String description;
    private String city;
    private String numberDays;
    private String price;

    private long petId;

}
