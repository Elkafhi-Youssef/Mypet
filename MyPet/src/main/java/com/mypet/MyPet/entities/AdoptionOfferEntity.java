package com.mypet.MyPet.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "AdoptionOffers")
public class AdoptionOfferEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5839697256499278436L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String adoptionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String numberDays;
    @Column(nullable = false)
    private String price;

    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonEntity person;

    @OneToMany(mappedBy = "adoptionOffer", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @ManyToOne
    @JoinColumn(name = "petid")
    private PetEntity pet;
}
