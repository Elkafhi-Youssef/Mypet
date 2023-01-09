package com.mypet.MyPet.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private  String  commentBody;

    @ManyToOne
    @JoinColumn(name = "adoptionId", nullable = false)
    private AdoptionOfferEntity adoptionOffer;

    @ManyToOne
    @JoinColumn(name = "personId", nullable = false)
    private PersonEntity person;

    @OneToMany(mappedBy = "comment")
    private List<ReplayEntity> replays;
}
