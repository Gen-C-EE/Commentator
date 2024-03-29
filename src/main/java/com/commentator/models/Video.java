package com.commentator.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="videos")
public class Video {
    @Id
    private String watchID;

    @OneToMany(mappedBy = "video", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentList;


    public Video(){

    }

    public Video(String watchID) {
        this.watchID = watchID;
    }

    public Video(String watchID,List<Comment> commentList){
        this.watchID = watchID;
        this.commentList = commentList;
    }

/*
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
*/

    public String getWatchID() {
        return watchID;
    }

    public void setWatchID(String watchID) {
        this.watchID = watchID;
    }

    @JsonManagedReference(value="video")
    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Video{" +
                "watchID='" + watchID + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
