package com.example.healthSquare.health_square.service;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Category;
import org.springframework.stereotype.Service;

/*created by Hector Developers
06-08-2019
*/

@Service
public interface CategoryService {
    Category updateCategory(Category category) throws ResourceNotFoundException;

    void deleteCategory(String message);

}
