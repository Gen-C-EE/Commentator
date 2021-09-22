package com.commentator.controllers;

import com.commentator.models.Comment;
import com.commentator.models.Video;
import com.commentator.services.CommentService;
import com.commentator.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService commentService){
        this.service=commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<Video> postComment(@RequestBody Comment comment){
        System.out.println(comment);
        Comment newComment = this.service.saveComment(comment);
        System.out.println(newComment);
        return new ResponseEntity(newComment, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable Long id) {
        return this.service.getComment(id);
    }



}