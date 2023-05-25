package com.store.inventorymanagement.infrastructure.adapters.driven.repositories;

import com.store.inventorymanagement.domain.entities.Product;
import com.store.inventorymanagement.domain.repository.crud.ProductCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRepository {

    private ProductCrudRepository productCrudRepository;

    public ProductRepository(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }

    public List<Product> getAllProducts(){ return productCrudRepository.findAll();}

    public Optional<Product> getProducrById(Long idProducto){ return productCrudRepository.getProductById(idProducto);}


}
