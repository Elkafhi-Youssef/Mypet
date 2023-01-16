package com.mypet.MyPet.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
@JsonIdentityInfo(         generator = ObjectIdGenerators.PropertyGenerator.class,         property = "id")
public class PersonEntity implements Serializable  {
    private static final long serialVersionUID = 861212087593794753L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
@Column(nullable = false )
    private String personId;

    @Column(nullable = false, length =50)
    private String fullName;

    @Column(nullable = false, length =50, unique = true)
    private String email;
    @Column(nullable = false)
    private String image;
    @Column(nullable = true , length =50)
    private String type ;
    @Column(nullable = false , length =50)
    private String phoneNumber;

    @Column(nullable = false)
    private String encryptedPassword;
    @Column(nullable = true)
    private String emailVerificationToken;
    @Column(nullable = false)
    private Boolean emailVerificationStatus = false ;
    @JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<AdoptionOfferEntity> adoptions;
    @OneToMany(mappedBy = "person")
    private List<CommentEntity> comments;
@JsonIgnore
    @OneToMany(mappedBy = "person")
    private List<PetEntity> pets;


}
