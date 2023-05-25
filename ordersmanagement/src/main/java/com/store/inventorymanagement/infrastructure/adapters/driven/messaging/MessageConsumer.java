package com.store.inventorymanagement.infrastructure.adapters.driven.messaging;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {


    @RabbitListener(queues = "${rabbitmq.queue-name-2}")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);


    }

}
