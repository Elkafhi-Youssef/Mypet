package com.mypet.MyPet.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pets")
public class PetEntity {
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
