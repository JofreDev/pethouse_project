package com.store.inventorymanagement.infrastructure.adapters.driven.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange-name}")
    private String exchangeName;

    // Envia mensajes a cola1
    @Value("${rabbitmq.routing-key-1}")
    private String routingKey;

    public void sendMessage(Object message) {
        amqpTemplate.convertAndSend(exchangeName, routingKey, message);
        System.out.println("Message sent: " + message);
    }
}
