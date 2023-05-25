package com.store.inventorymanagement.domain.repository.crud;

import com.store.inventorymanagement.domain.dtos.Out.CategoryWithSubcategoriesDto;
import com.store.inventorymanagement.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/* CrudRepository recibe dos parámetros :
 * Tabla y tipo de dato de la llave primaria (tabla,Tipo_dato_llave)
 */

@Repository
public interface CategoryCrudRepository extends JpaRepository<Category, Long> {

    // Retornar categoria por  id
    @Query(value = "SELECT c FROM Category c WHERE c.id =?1")
    Optional<Category> getCategoryById(Long idCategory);

    // Retornar subcategorias por categoria

    @Query(value = "SELECT new com.store.inventorymanagement.domain.dtos.Out.CategoryWithSubcategoriesDto" +
            "(c.id, c.nombre, c.subCategory) " +
            "FROM Category c " +
            "WHERE c.id =:parametroid")
    Optional<CategoryWithSubcategoriesDto> getCategoryWithSubcategoriesById(@Param("parametroid") Long id);




}
