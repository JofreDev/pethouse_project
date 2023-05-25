package com.store.inventorymanagement.domain.dtos.In;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

    private Long idCliente;
}
