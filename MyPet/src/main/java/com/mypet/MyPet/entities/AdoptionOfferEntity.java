package com.mypet.MyPet.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "personid")
    private PersonEntity person;

    @JsonIgnore
    @OneToMany(mappedBy = "adoptionOffer", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "petid")
    private PetEntity pet;
}
