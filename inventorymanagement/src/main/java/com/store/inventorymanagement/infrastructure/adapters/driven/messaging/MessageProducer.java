package com.store.inventorymanagement.infrastructure.adapters.driven.messaging;

import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class MessageProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange-name}")
    private String exchangeName;

    @Value("${rabbitmq.routing-key-2}")
    private String routingKey;

    private ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @PostConstruct
    public void init() {
        scheduler.scheduleAtFixedRate(this::sendMessage, 0, 20, TimeUnit.SECONDS);
    }

    public void sendMessage() {
        Object message = "Mensaje de aviso desde Gestion de inventario !"; // Aquí obtiene el mensaje que quiere enviar
        amqpTemplate.convertAndSend(exchangeName, routingKey, message);
        System.out.println("Message sent: " + message);
    }


}



