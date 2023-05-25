package com.store.inventorymanagement.domain.repository.crud;
import com.store.inventorymanagement.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCrudRepository extends JpaRepository<Product, Long> {


    // Devolver productos en función de la subcategoria.
    @Query(value = "SELECT p FROM Product p WHERE p.id =?1")
    Optional<Product> getProductById(Long idProduct);

    // Productos mayores a determinado precio

    Optional<List<Product>> findByPrecioGreaterThan(Double precio);

    // Producto menores a determinado precio

    Optional<List<Product>> findByPrecioLessThan(Double precioLimite);

    // Productos sin Stock
    @Query(value = "SELECT p FROM Product p WHERE p.cantidadStock = 0")
    List<Product> findOutOfStockProducts();

    // Productos con poco stock

    Optional<List<Product>> findBycantidadStockLessThan(Integer cantidad);

    // Producto por subcategoria
   // @Query(value = "SELECT p FROM Product p WHERE p.id =?1")
   // Optional<Product> getProductById(Long idProduct);

    // Producto por categoria
   // @Query(value = "SELECT p FROM Product p WHERE p.id =?1")
    // Optional<Product> getProductById(Long idProduct);


}
