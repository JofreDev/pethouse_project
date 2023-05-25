package com.store.inventorymanagement.infrastructure.adapters.driven.controller;


import com.store.inventorymanagement.domain.dtos.Out.CategoryOutDto;
import com.store.inventorymanagement.domain.dtos.Out.SubCategoryOutDto;
import com.store.inventorymanagement.infrastructure.adapters.driven.messaging.MessageConsumer;
import com.store.inventorymanagement.infrastructure.adapters.driven.messaging.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/subcategories")
public class SubCategoryRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${REST.API.SUBCATEGORY}")
    private String apiYUrl ;



    @GetMapping("/")
    public ResponseEntity<List<SubCategoryOutDto>> getAll() throws InterruptedException {
        // hacer una llamada GET a la otra API
        ResponseEntity<List<SubCategoryOutDto>> responseEntity = restTemplate.
                exchange(apiYUrl+"/", HttpMethod.GET, null, new ParameterizedTypeReference<List<SubCategoryOutDto>>() {});

        // obtener los datos de la respuesta
        List<SubCategoryOutDto> myObjects = responseEntity.getBody();

        return ResponseEntity.ok(myObjects);
    }

    @GetMapping(value ="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubCategoryOutDto> getById(@PathVariable Long id) {
        // hacer una llamada GET a la otra API
        ResponseEntity<SubCategoryOutDto> responseEntity = restTemplate.
                exchange(apiYUrl+"/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<SubCategoryOutDto>() {});

        // obtener los datos de la respuesta
        SubCategoryOutDto myObjects = responseEntity.getBody();

        return ResponseEntity.ok(myObjects);
    }


    @GetMapping("/getsubcategoriesbyidcategory/{id}")
    public ResponseEntity<List<SubCategoryOutDto>> getSubCategoriesByIdCategory(@PathVariable Long id) throws InterruptedException {
        // hacer una llamada GET a la otra API
        ResponseEntity<List<SubCategoryOutDto>> responseEntity = restTemplate.
                exchange(apiYUrl+"/getsubcategories/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<List<SubCategoryOutDto>>() {});

        // obtener los datos de la respuesta
        List<SubCategoryOutDto> myObjects = responseEntity.getBody();

        return ResponseEntity.ok(myObjects);
    }


}
