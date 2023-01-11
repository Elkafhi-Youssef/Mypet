package com.mypet.MyPet.requests;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PetRequest {
    private Long personid;
    private String petname;
    private int age;
    private String type;
    private String images;
}
