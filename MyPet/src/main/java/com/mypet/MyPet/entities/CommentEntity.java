package com.mypet.MyPet.entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Comments")
@JsonIdentityInfo(         generator = ObjectIdGenerators.PropertyGenerator.class,         property = "id")
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
