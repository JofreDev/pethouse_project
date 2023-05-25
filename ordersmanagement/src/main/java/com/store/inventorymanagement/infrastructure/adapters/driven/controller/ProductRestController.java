package com.store.inventorymanagement.infrastructure.adapters.driven.controller;


import com.store.inventorymanagement.domain.dtos.In.ProductInDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${REST.API.PRODUCT}")
    private String apiYUrl ;


    @GetMapping("/")
    public ResponseEntity<ProductInDto> getAll(){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInDto> getById(@PathVariable Long id){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{idCategory}")
    public ResponseEntity<ProductInDto> getByIdCategoy(@PathVariable Long idCategory){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{idSubCategory}")
    public ResponseEntity<ProductInDto> getByIdSubCategoy(@PathVariable Long idSubCategory){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{nameSubCategory}")
    public ResponseEntity<ProductInDto> getByNameSubCategoy(@PathVariable Long idSubCategory){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{nameCategory}")
    public ResponseEntity<ProductInDto> getByNameCategoy(@PathVariable Long idCategory){

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
