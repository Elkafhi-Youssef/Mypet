package com.mypet.MyPet.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "replays")
public class ReplayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private  String  replayBody;

    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private CommentEntity comment;
}
