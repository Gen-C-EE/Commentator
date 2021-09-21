package com.commentator.services;


import com.commentator.models.User;
import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

@Service
public class VideoService {

    private VideoRepository repo;

    @Autowired
    public VideoService(VideoRepository repo){
        this.repo = repo;
    }

    public Video saveVideo(Video video){
        return this.repo.save(video);
    }

    public Video getVideo(String id){
        return repo.findById(id).orElse(null);
    }

    /*
    public Video getVideoByWatchId(@Min(value = 1L, message = "Invalid id") Long id){
        return repo.findById(id).orElse(null);
    }*/

}
