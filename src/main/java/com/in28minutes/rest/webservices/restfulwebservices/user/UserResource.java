package com.in28minutes.rest.webservices.restfulwebservices.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService service;


    public UserResource(UserDaoService service){
        this.service = service;
    }


    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // GET /users
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
       return service.findById(id);
    }

    // POST /users
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        // location - /users/4

        // This will create a location section when calling API, for API consumers convenience
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();

    }

}
