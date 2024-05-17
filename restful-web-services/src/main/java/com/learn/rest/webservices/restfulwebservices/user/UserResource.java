package com.learn.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;

@RestController
public class UserResource {

    private final UserDaoService userDaoService;

    @Autowired
    public UserResource(final UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers() {
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUserById(@PathVariable("id") final int id) {
        return userDaoService.findUserById(id);
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {
        User newUser = userDaoService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        MultiValueMap<String, String> headersMap = new HttpHeaders();
        headersMap.put("location", Collections.singletonList(location.toString()));
        return new ResponseEntity<>(newUser, headersMap, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping(path = "/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") final Integer id) {
        userDaoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
