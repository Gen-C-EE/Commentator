package com.commentator.models;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User author;
    private String text;

    @ManyToOne
    @JoinColumn(name="video_id")
    private Video video;


}
