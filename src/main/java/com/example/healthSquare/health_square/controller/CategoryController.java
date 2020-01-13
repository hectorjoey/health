package com.example.healthSquare.health_square.controller;

import com.example.healthSquare.health_square.model.Category;
import com.example.healthSquare.health_square.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*created by Hector Developers
06-08-2019
*/
@RestController
@RequestMapping("/v1/group")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/list")
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @GetMapping(value = "/{categoryname}")
    public Optional<Category> findByCategoryname(@PathVariable String categoryname ){
        return categoryRepository.findByCategoryname(categoryname);
    }

    @PostMapping(value = "/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

}
