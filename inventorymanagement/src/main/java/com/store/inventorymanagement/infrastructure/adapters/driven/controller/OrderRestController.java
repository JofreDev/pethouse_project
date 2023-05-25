package com.store.inventorymanagement.infrastructure.adapters.driven.controller;

import com.store.inventorymanagement.domain.dtos.In.OrderInDto;
import com.store.inventorymanagement.domain.dtos.Out.ResponsePurchaseRequestDto;
import com.store.inventorymanagement.infrastructure.adapters.driven.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/order")
public class OrderRestController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/buy_products")
    ResponseEntity<ResponsePurchaseRequestDto> newUser(@RequestBody OrderInDto order){
        return new ResponseEntity<>(orderRepository.verify(order), HttpStatus.OK);
    }

}
