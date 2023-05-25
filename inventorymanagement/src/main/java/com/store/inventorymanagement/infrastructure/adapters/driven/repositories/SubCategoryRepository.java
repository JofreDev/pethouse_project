package com.store.inventorymanagement.infrastructure.adapters.driven.repositories;

import com.store.inventorymanagement.domain.entities.SubCategory;
import com.store.inventorymanagement.domain.repository.crud.SubCategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryRepository {


    private SubCategoryCrudRepository subCategoryCrudRepository;

    public SubCategoryRepository(SubCategoryCrudRepository subCategoryCrudRepository) {
        this.subCategoryCrudRepository = subCategoryCrudRepository;
    }

    public List<SubCategory> getAllSubCategories(){return subCategoryCrudRepository.findAll();}

    public Optional<SubCategory> getSubCategoryById(Long idSubCategory){return subCategoryCrudRepository.
            getSubCategoryById(idSubCategory);}

    public List<SubCategory>  getSubCategoriesByIdCategory(Long idCategory){return subCategoryCrudRepository.
            findSubCategoriesByCategoryId(idCategory);}
}
