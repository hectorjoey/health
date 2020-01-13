package com.example.healthSquare.health_square.serviceImpl;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Category;
import com.example.healthSquare.health_square.repository.CategoryRepository;
import com.example.healthSquare.health_square.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Category updateCategory(Category category) throws ResourceNotFoundException {
        Optional<Category> categoryOptional = this.categoryRepository.findByCategoryname(category.getCategoryname());

        if (categoryOptional.isPresent()) {
            Category categoryUpdate = categoryOptional.get();
            categoryUpdate.setCategoryname(category.getCategoryname());
            categoryRepository.save(categoryUpdate);
            return categoryUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with title : " + category.getCategoryname());
        }
    }

    @Override
    public void deleteCategory(String message) {

    }

}
