package com.store.inventorymanagement.domain.repository.crud;
import com.store.inventorymanagement.domain.entities.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentCrudRepository extends JpaRepository<Shipment, Long> {
}
