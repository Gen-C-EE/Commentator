package com.commentator.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToMany()
    @JoinColumn(name="videos")
    private List<Video> history;

    public History(){
        //history = new ArrayList<Video>();
    }

    public History(User user){
        this.user=user;
        history = new ArrayList<Video>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Video> getHistory() {
        return history;
    }

    public void setHistory(List<Video> history) {
        this.history = history;
    }
}
