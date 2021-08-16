package com.commentator.services;

import com.commentator.models.*;
import com.commentator.repositories.*;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Min;

@Service
public class UserService {
    private UserRepository repo;

    public UserService(UserRepository repo){
        this.repo=repo;
    }

    public User saveUser(User user){
        return this.repo.save(user);
    }

    public User getUser(@Min(value = 1L, message = "Invalid product ID.") Long id){
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        repo.deleteById(id);
    }

}
