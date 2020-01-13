package com.example.healthSquare.health_square.repository;

import com.example.healthSquare.health_square.model.Comment;
import com.example.healthSquare.health_square.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findCommentsByUsers(Users users);
    Comment save(Comment comment);

    Optional<Comment> findCommentByMessage(String message);
}
