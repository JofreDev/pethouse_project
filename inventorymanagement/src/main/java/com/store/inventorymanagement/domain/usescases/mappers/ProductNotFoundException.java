package com.store.inventorymanagement.domain.usescases.mappers;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // puedes agregar otros constructores si los necesitas
}

