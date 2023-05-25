package com.store.inventorymanagement.infrastructure.adapters.driven.controller;


import com.store.inventorymanagement.domain.dtos.Out.CategoryOutDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/categories")
public class CategoryRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${REST.API.CATEGORY}")
    private String apiYUrl ;




    @GetMapping(value ="/",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryOutDto>> getAll() {
        // hacer una llamada GET a la otra API
        ResponseEntity<List<CategoryOutDto>> responseEntity = restTemplate.
                exchange(apiYUrl+"/", HttpMethod.GET, null, new ParameterizedTypeReference<List<CategoryOutDto>>() {});

        // obtener los datos de la respuesta
        List<CategoryOutDto> myObjects = responseEntity.getBody();

        return ResponseEntity.ok(myObjects);
    }

    @GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryOutDto> getById(@PathVariable Long id) {
        // hacer una llamada GET a la otra API
        ResponseEntity<CategoryOutDto> responseEntity = restTemplate.
                exchange(apiYUrl+"/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<CategoryOutDto>() {});

        // obtener los datos de la respuesta
        CategoryOutDto myObjects = responseEntity.getBody();

        return ResponseEntity.ok(myObjects);
    }





}
