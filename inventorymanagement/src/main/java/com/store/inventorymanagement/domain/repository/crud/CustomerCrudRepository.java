package com.store.inventorymanagement.domain.repository.crud;

import com.store.inventorymanagement.domain.entities.Customer;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerCrudRepository extends JpaRepository<Customer, String> {

    @Query("Select u from Customer u where u.correoElectronico =?1") // Usando JPQL
    Optional<Customer> findUserByEmail(String email);

    @Query("select u from Customer u where u.nombre like ?1%") // Buscar y ordenar a partir de un nombre.
    List<Customer> findAndSort(String name, Sort sort);

    //List<Customer> findByName(String name);

    //List<Customer> findByEmailAndName(String email,String name);
}
