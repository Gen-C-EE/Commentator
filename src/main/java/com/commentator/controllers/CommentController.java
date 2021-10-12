package com.commentator.controllers;

import com.commentator.models.Comment;
import com.commentator.models.Video;
import com.commentator.services.CommentService;
import com.commentator.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService commentService){
        this.service=commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<Video> postComment(@RequestBody Comment comment){
        //System.out.println(comment);
        Comment newComment = this.service.saveComment(comment);
        //System.out.println(newComment);
        return new ResponseEntity(newComment, HttpStatus.OK);
    }

    @GetMapping("/comments/{id}")
    public Comment getComment(@PathVariable Long id) {
        return this.service.getComment(id);
    }

    @PatchMapping("/comments/{id}")
    public Comment editComment(@PathVariable Long id, @RequestBody String newText) {
        return this.service.editComment(id,newText);
    }

    @PatchMapping("/comments/{id}/delete")
    public Comment deleteComment(@PathVariable Long id) {
        return this.service.deleteComment(id);
    }

}