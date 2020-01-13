package com.example.healthSquare.health_square.controller;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.repository.PostRepository;
import com.example.healthSquare.health_square.model.Post;
import com.example.healthSquare.health_square.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@RestController
@RequestMapping("/v1/post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService postService;

    @GetMapping(value = "/list")
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @GetMapping(value = "/{title}")
    public Optional<Post> getPost(@PathVariable String title) {
        return postRepository.findByTitle(title);
    }

    @PostMapping(value = "/add")
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @PutMapping("/post/{title}")
    public ResponseEntity<Post> updatePost(@PathVariable String title, @RequestBody Post post) throws ResourceNotFoundException {
        post.setTitle(title);
        return ResponseEntity.ok().body(this.postService.updatePost(post));
    }

    @DeleteMapping("/{title}")
    public HttpStatus deletePost(@PathVariable String title) throws ResourceNotFoundException {
        this.postService.deletePost(title);
        return HttpStatus.FORBIDDEN;
    }
}