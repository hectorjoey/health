package com.example.healthSquare.health_square.repository;

import com.example.healthSquare.health_square.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    Optional<Post> findByTitle(String title);
}
