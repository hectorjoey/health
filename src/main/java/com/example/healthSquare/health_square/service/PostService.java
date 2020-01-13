package com.example.healthSquare.health_square.service;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Post;
import org.springframework.stereotype.Service;

/*created by Hector Developers
06-08-2019
*/

@Service
public interface PostService {

    Post updatePost(Post post) throws ResourceNotFoundException;

    void deletePost(String title) throws ResourceNotFoundException;
}
