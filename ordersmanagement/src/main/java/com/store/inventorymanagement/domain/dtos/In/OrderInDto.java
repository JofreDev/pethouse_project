package com.store.inventorymanagement.domain.dtos.In;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)

public class OrderInDto {


    private List<ProductInDto> products;

    private CustomerDto customer;



}
