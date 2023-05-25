package com.store.inventorymanagement.domain.dtos.Out;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class CategoryOutDto {

        private Long id;

        private String nombre;

        @JsonCreator
        public CategoryOutDto() {
        }
}
