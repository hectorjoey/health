package com.example.healthSquare.health_square.repository;

import com.example.healthSquare.health_square.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    Optional<Category> findByCategoryname(String categoryname);

}
