package com.learn.rest.webservices.restfulwebservices.user;

import com.learn.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserJpaResource(final UserRepository userRepository,
                           final PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping(path = "/jpa/users")
    public List<User> retrieveAllUsers() {
//        return userDaoService.findAll();
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return optionalUser.get().getPosts();
    }

    @GetMapping(path = "/jpa/users/{user_id}/posts/{post_id}")
    public Post retrievePostForUser(@PathVariable("user_id") int userId, @PathVariable("post_id") int postId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }
        return postRepository.findByIdAndUser_id(postId, userId);
    }

    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostForUser(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }

        post.setUser(optionalUser.get());
        Post savePost = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savePost.getId()).toUri();
        MultiValueMap<String, String> headersMap = new HttpHeaders();
        headersMap.put("location", Collections.singletonList(location.toString()));
        return new ResponseEntity<>(savePost, headersMap, HttpStatusCode.valueOf(201));
    }

    @GetMapping(path = "/jpa/users/{id}")
    public EntityModel<User> retrieveUserById(@PathVariable("id") final int id) {
//        User user = userDaoService.findUserById(id);
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        EntityModel<User> entityModel = EntityModel.of(optionalUser.get());
        WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(linkBuilder.withRel("all-users"));
        return entityModel;
    }

    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody final User user) {
//        User newUser = userDaoService.createUser(user);
        User newUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();
        MultiValueMap<String, String> headersMap = new HttpHeaders();
        headersMap.put("location", Collections.singletonList(location.toString()));
        return new ResponseEntity<>(newUser, headersMap, HttpStatusCode.valueOf(201));
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") final Integer id) {
//        userDaoService.deleteById(id);
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
