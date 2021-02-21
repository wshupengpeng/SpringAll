package com.rabbit.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping(value = "/sendMessage",method = RequestMethod.GET)
    public String sendMessage(String routingKey,String msg){
        rabbitTemplate.convertAndSend("spring_exchange",routingKey,msg);
        return "success";
    }
}
