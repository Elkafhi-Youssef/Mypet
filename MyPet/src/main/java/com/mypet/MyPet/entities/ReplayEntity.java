package com.mypet.MyPet.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "replays")
@JsonIdentityInfo(         generator = ObjectIdGenerators.PropertyGenerator.class,         property = "id")
public class ReplayEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -2182759419831304602L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String  replayBody;

    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private CommentEntity comment;
}
