package com.store.inventorymanagement.infrastructure.adapters.driven.controller;

import com.store.inventorymanagement.domain.entities.Category;
import com.store.inventorymanagement.domain.entities.SubCategory;
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
@RequestMapping("/api/subcategories")
public class SubCategoryRestController {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @GetMapping("/")
    public ResponseEntity<List<SubCategory>> getAll() throws InterruptedException {

        List<SubCategory> subCategories = subCategoryRepository.getAllSubCategories();
        return new ResponseEntity<>(subCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getById(@PathVariable Long id) throws InterruptedException {

        Optional<SubCategory> subCategory = subCategoryRepository.getSubCategoryById(id);

        if(subCategory.isPresent()){
            return new ResponseEntity<>(subCategory.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getsubcategories/{id}")
    public ResponseEntity<List<SubCategory>> getSubcategoriesById(@PathVariable Long id) throws InterruptedException {

        List<SubCategory> subCategories =  subCategoryRepository.getSubCategoriesByIdCategory(id);

        if (!subCategories.isEmpty()) {
            return new ResponseEntity<>(subCategories, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



}
