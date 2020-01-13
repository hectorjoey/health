package com.example.healthSquare.health_square.serviceImpl;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Post;
import com.example.healthSquare.health_square.repository.PostRepository;
import com.example.healthSquare.health_square.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Service
@Transactional
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;


    @Override
    public Post updatePost(Post post) throws ResourceNotFoundException {
        Optional<Post> postOptional = this.postRepository.findByTitle(post.getTitle());

        if (postOptional.isPresent()) {
            Post postUpdate = postOptional.get();
            postUpdate.setTitle(post.getTitle());
            postUpdate.setContents(post.getContents());
            postRepository.save(postUpdate);
            return postUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with title : " + post.getTitle());
        }
    }


    @Override
    public void deletePost(String title) throws ResourceNotFoundException {
        Optional<Post> postOptional = this.postRepository.findByTitle(title);

        if (postOptional.isPresent()) {
            this.postRepository.delete(postOptional.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + title);
        }
    }
}
