package com.store.inventorymanagement.infrastructure.adapters.driven.controller;


import com.store.inventorymanagement.domain.dtos.Out.CategoryWithSubcategoriesDto;
import com.store.inventorymanagement.domain.entities.Category;
import com.store.inventorymanagement.domain.entities.SubCategory;
import com.store.inventorymanagement.infrastructure.adapters.driven.repositories.CategoryRepository;
import com.store.inventorymanagement.infrastructure.adapters.driven.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;




    @GetMapping("/")
    public ResponseEntity<List<Category>> getAll() throws InterruptedException {

        List<Category> categories = categoryRepository.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) throws InterruptedException {

        Optional<Category> category = categoryRepository.getCategoryById(id);

        if(category.isPresent()){
            return new ResponseEntity<>(category.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
