package com.mypet.MyPet.dto;

import com.mypet.MyPet.entities.PersonEntity;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
@Data
public class PetDto  implements Serializable {

    @Serial
    private static final long serialVersionUID = -3560643177398897002L;
    private String petname;
    private int age;
    private String type;
    private String images;

    private PersonDto person;
}
