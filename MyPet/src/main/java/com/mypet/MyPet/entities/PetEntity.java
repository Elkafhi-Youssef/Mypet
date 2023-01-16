package com.mypet.MyPet.entities;

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
    @Lob
    @Column(nullable = false,columnDefinition = "text")
    private String image;
    @JsonIgnore
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<AdoptionOfferEntity> adoptions;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personid")
    private PersonEntity person;
}
