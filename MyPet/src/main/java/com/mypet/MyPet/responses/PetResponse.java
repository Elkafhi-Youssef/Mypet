package com.mypet.MyPet.responses;

import lombok.Data;

@Data
public class PetResponse {
    private String petname;
    private int age;
    private String type;
    private String image;
    private PersonResponse person;

}
