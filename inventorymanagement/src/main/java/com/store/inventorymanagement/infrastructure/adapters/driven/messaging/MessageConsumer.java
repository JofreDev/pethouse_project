package com.store.inventorymanagement.infrastructure.adapters.driven.messaging;

import com.store.inventorymanagement.infrastructure.adapters.driven.repositories.CategoryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageConsumer {


    @RabbitListener(queues = "${rabbitmq.queue-name-1}")
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);


    }
}
