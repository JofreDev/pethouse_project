package com.store.inventorymanagement.domain.entities;

import jakarta.persistence.*;

@Entity
@Table(name="product_order")
public class ProductOrder {

    @EmbeddedId // -> La llave primaria es compuesta y por lo tanto está dada por otra clase
    private ProductOrderPK id;

    private Integer cantidad;

    private Double total;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_order", insertable = false,updatable = false)
    private Order order;





}
