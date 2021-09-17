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

    @OneToOne(optional=true)
    private Comment parent;
    private String timestamp;

    @ManyToOne
    @JoinColumn(name="video_id")
    private Video video;

    public Comment() {

    }

    public Comment(User author, String text, Comment parent, String timestamp, Video video) {
        this.author = author;
        this.text = text;
        this.parent = parent;
        this.timestamp = timestamp;
        this.video = video;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
