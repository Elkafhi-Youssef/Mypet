package com.mypet.MyPet.entities;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "AdoptionOffers")
@JsonIdentityInfo(         generator = ObjectIdGenerators.PropertyGenerator.class,         property = "id")
public class AdoptionOfferEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -5839697256499278436L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false )
    private String adoptionId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String numberDays;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false,columnDefinition = "boolean default false")
    private  Boolean status = false;


    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "personacceptedid")
    private PersonEntity personaccepted;

    @OneToMany(mappedBy = "adoptionOffer", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;

    @ManyToOne
    @JoinColumn(name = "petid")
    private PetEntity pet;
}
