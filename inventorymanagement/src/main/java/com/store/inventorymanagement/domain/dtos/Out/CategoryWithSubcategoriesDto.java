package com.store.inventorymanagement.domain.dtos.Out;

import com.store.inventorymanagement.domain.entities.SubCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryWithSubcategoriesDto {

    private Long id;

    private String nombre;

    private List<SubCategory> subcategories;

    public CategoryWithSubcategoriesDto(Long id, String nombre, List<SubCategory> subcategories) {
        this.id = id;
        this.nombre = nombre;
        this.subcategories = subcategories;
    }
}
