package com.store.inventorymanagement.domain.repository.crud;

import com.store.inventorymanagement.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCrudRepository extends JpaRepository<Order, Long> {
}
