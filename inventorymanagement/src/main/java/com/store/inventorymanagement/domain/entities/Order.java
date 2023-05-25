package com.store.inventorymanagement.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order",nullable = false, unique = true)
    private Long id;

    private LocalDateTime fecha;

    private String estado;

    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    private  Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_shipment", insertable = false, updatable = false)
    private Shipment shipment;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductOrder> productOrders = new ArrayList<>();



}
