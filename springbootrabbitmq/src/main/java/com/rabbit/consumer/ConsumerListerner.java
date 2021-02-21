package com.rabbit.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListerner {
    @RabbitListener(queues = "spring_rabbitqueue")
    public void recevier(String msg){
        System.out.println(msg);
    }
}
