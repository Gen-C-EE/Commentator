package com.commentator.services;


import com.commentator.models.Comment;
import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.repositories.CommentRepository;
import com.commentator.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

@Service
public class CommentService {

    private CommentRepository repo;

    @Autowired
    public CommentService(CommentRepository repo){
        this.repo = repo;
    }

    public Comment saveComment(Comment comment){
        return this.repo.save(comment);
    }

    public Comment getComment(@Min(value = 1L, message = "Invalid id") Long id){
        return repo.findById(id).orElse(null);
    }

}
