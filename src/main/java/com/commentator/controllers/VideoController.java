package com.commentator.controllers;

import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VideoController {

    private final VideoService service;

    @Autowired
    public VideoController(VideoService videoService){
        this.service=videoService;
    }

    @PostMapping("/videos")
    public ResponseEntity<Video> postVideo(@RequestBody Video video){
        Video newVideo = this.service.saveVideo(video);
        return new ResponseEntity(newVideo, HttpStatus.OK);
    }

}
