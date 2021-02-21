package com.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Bean
    public Queue queue(){
        return QueueBuilder.durable("spring_rabbitqueue")
                .autoDelete().build();
    }


    @Bean
    public TopicExchange topicExchange(){
        return ExchangeBuilder.topicExchange("spring_exchange")
                .build();
    }


    @Bean
    public Binding binding(){
        return BindingBuilder
                .bind(queue())
                .to(topicExchange())
                .with("spring_rabbit");
    }


}
