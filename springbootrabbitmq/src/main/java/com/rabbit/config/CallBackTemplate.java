package com.rabbit.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class CallBackTemplate implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void confirm(CorrelationData correlationData, boolean b, String s) {

    }

    public void returnedMessage(Message message, int i, String s, String s1, String s2) {

    }

    @Bean
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
        // andatory为true时,消息通过交换器无法匹配到队列会返回给生产者 并触发MessageReturn
        //  为false时,匹配不到会直接被丢弃
        rabbitTemplate.setMandatory(true);
    }

    public void test(Channel channel){
    }


}
