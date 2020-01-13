package com.example.healthSquare.health_square.controller;

import com.example.healthSquare.health_square.repository.CommentRepository;
import com.example.healthSquare.health_square.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*created by Hector
06-08-2019
*/
@RestController
@RequestMapping("/v1/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping(value = "/list")
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> createComment(@RequestBody Comment comment){
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }
}
