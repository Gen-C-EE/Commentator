package com.commentator.controllers;

import com.commentator.models.User;
import com.commentator.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@RestController
public class UserController {
    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        return this.service.getUser(id);
    }

    @PostMapping("/users")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        //System.out.println(product + " " + product.getBrand());
        User newUser = this.service.saveUser(user);
        return new ResponseEntity(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Null> deleteUser(@PathVariable Long id) {
        this.service.deleteUser(id);
        return new ResponseEntity(null, HttpStatus.OK);
    }

}
