package com.example.healthSquare.health_square.controller;

import com.example.healthSquare.health_square.exception.ResourceNotFoundException;
import com.example.healthSquare.health_square.model.Category;
import com.example.healthSquare.health_square.model.Post;
import com.example.healthSquare.health_square.repository.CategoryRepository;
import com.example.healthSquare.health_square.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    CategoryService categoryService;

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


    @PutMapping("/category/{name}")
    public ResponseEntity<Category> updateCategory(@PathVariable String name, @RequestBody Category category) throws ResourceNotFoundException {
        category.setCategoryname(name);
        return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
    }

}
