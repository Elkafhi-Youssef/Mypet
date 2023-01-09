package com.mypet.MyPet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "pets")
public class PetEntity  implements Serializable {
    @Serial
    private static final long serialVersionUID = 5169978146215719285L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String petname;
    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private String images;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private List<AdoptionOfferEntity> adoptions;
    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonEntity person;
}
