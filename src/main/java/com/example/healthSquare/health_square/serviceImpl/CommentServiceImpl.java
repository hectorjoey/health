package com.example.healthSquare.health_square.serviceImpl;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Comment;
import com.example.healthSquare.health_square.model.Post;
import com.example.healthSquare.health_square.repository.CommentRepository;
import com.example.healthSquare.health_square.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;


    @Override
    public Comment updateComment(Comment comment) throws ResourceNotFoundException {
        Optional<Comment> commentOptional = this.commentRepository.findCommentsByUsers(comment.getUsers());

        if (commentOptional.isPresent()) {
            Comment commentUpdate = commentOptional.get();
            commentUpdate.setMessage(comment.getMessage());
            commentRepository.save(commentUpdate);
            return commentUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with title : " + comment.getUsers());
        }
    }

    @Override
    public void deleteComment(String message) throws ResourceNotFoundException {
        Optional<Comment> commentOptional = this.commentRepository.findCommentByMessage(message);

        if (commentOptional.isPresent()) {
            this.commentRepository.delete(commentOptional.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + message);
        }
    }
}

