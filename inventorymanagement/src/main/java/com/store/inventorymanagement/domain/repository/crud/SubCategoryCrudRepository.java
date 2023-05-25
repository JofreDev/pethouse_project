package com.store.inventorymanagement.domain.repository.crud;

import com.store.inventorymanagement.domain.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubCategoryCrudRepository extends JpaRepository<SubCategory, Long> {


    // Retornar categoria por  id
    @Query(value = "SELECT s FROM SubCategory s WHERE s.id =?1")
    Optional<SubCategory> getSubCategoryById(Long idSubCategory);

    // Retornar Subcategorias por categoria

    @Query("SELECT c.subCategory FROM Category c WHERE c.id = :categoryId")
    List<SubCategory> findSubCategoriesByCategoryId(@Param("categoryId") Long categoryId);


}
