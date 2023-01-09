package com.mypet.MyPet.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
@Table(name = "replays")
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
