package com.mypet.MyPet.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Data
@Entity
@Table(name = "Comments")
public class CommentEntity  implements Serializable {

    @Serial
    private static final long serialVersionUID = 6523371765494197063L;
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
