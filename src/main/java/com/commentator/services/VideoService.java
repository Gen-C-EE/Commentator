package com.commentator.services;


import com.commentator.models.Video;
import com.commentator.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
