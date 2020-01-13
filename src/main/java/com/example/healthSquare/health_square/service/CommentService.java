package com.example.healthSquare.health_square.service;

import com.example.healthSquare.health_square.model.Comment;
import org.springframework.stereotype.Service;

/*created by Hector Developers
06-08-2019
*/

@Service
public interface CommentService {

    Comment updateComment(Comment comment);

    void deleteComment(String message);
}
