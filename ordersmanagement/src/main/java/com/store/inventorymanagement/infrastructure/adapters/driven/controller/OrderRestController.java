package com.store.inventorymanagement.infrastructure.adapters.driven.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.store.inventorymanagement.domain.dtos.In.OrderInDto;
import com.store.inventorymanagement.domain.dtos.In.ResponsePurchaseRequestDto;
import com.store.inventorymanagement.infrastructure.adapters.driven.messaging.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController // Hereda de la notación controller. Todos los metodos acá se formatean a JSON
@RequestMapping("/api/orders")
public class OrderRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MessageProducer messageProducer;

    @Value("${REST.API.ORDER}")
    private String apiYUrl ;



    /*En caso de que se cuente con suficiente inventario y los productos sean adecuados,
     *el servicio de gestión de inventario tendrá que aprobar la compra, tras lo cual se notificará
     * a los servicios de gestión de inventario y envío a través de la cola1. La notificación incluirá
     * las siguientes acciones:
     * 1) el servicio de gestión de inventario deberá registrar una nueva compra con envío en proceso, y
     * 2) el servicio de envío deberá atender un nuevo envío pendiente.*/


    @PostMapping("/comprar/productos")
    // Por defecto está sobre Tomcat !!
    public ResponseEntity<ResponsePurchaseRequestDto> comprarProductos(@RequestBody OrderInDto order) throws JsonProcessingException {



        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(order);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        // Primero se hace una verificación por REST

        // hacer una llamada POST a la otra API
        ResponseEntity<ResponsePurchaseRequestDto> responseEntity = restTemplate.
                exchange(apiYUrl+"/buy_products", HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ResponsePurchaseRequestDto>() {});

        // obtener los datos de la respuesta
        ResponsePurchaseRequestDto myObject= responseEntity.getBody();

        if(myObject.isAprobado()){

            /// Se envia el mensaje de que hay una compra aprobada

            messageProducer.sendMessage("**** Hay una nueva venta aprobada ****"+
                    " - mensaje :"+myObject.getMensaje());

        }

        return ResponseEntity.ok(myObject);

    }





}
