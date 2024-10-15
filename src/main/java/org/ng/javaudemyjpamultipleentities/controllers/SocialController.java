package org.ng.javaudemyjpamultipleentities.controllers;

import org.ng.javaudemyjpamultipleentities.models.SocialUser;
import org.ng.javaudemyjpamultipleentities.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("social/users")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser), HttpStatus.OK);
    }

    @DeleteMapping("social/users")
    public ResponseEntity<String> getUsers(@Param("id") Long id){
        try {
            socialService.deleteUser(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
