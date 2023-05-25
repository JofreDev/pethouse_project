package com.store.inventorymanagement.infrastructure.adapters.driven.repositories;

import com.store.inventorymanagement.domain.dtos.Out.CategoryWithSubcategoriesDto;
import com.store.inventorymanagement.domain.entities.Category;
import com.store.inventorymanagement.domain.repository.crud.CategoryCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryRepository {

    private CategoryCrudRepository categoryCrudRepository;

    public CategoryRepository(CategoryCrudRepository categoryCrudRepository) {
        this.categoryCrudRepository = categoryCrudRepository;
    }

    public List<Category> getAllCategories(){return categoryCrudRepository.findAll();}

    public Optional<Category> getCategoryById(Long idCategory){return categoryCrudRepository.
            getCategoryById(idCategory);}

    public Optional<CategoryWithSubcategoriesDto> getCategoryWithSubcategoriesById(Long idCategory){
        return categoryCrudRepository.getCategoryWithSubcategoriesById(idCategory);
    }

}
