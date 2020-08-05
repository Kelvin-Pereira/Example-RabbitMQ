package com.example.api.service;

import com.example.api.util.rabbitmq.RabbitmqConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMqService {

    private final RabbitmqConfiguration rabbitmqConfiguration;

    @Qualifier("RabbitTemplate")
    private final RabbitTemplate rabbitTemplate;

    public void direct() {
        rabbitTemplate.convertAndSend("MinhaExchangesDirect",  "key1", "msgAqui");
    }

    public void fanout() {
        rabbitTemplate.convertAndSend("MinhaExchangesFanout", "", "msgAqui");
    }

    public void topic(String key) {
        rabbitTemplate.convertAndSend("MinhaExchangesTopic", key, "msgAqui");
    }

    public void header(String valor) {
        rabbitTemplate.convertAndSend("MinhaExchangesHeader", "", "msgAqui", message -> {
            message.getMessageProperties().getHeaders().put("CHAVE", valor);
            message.getMessageProperties().getHeaders().put("CHAVE2", "CHAVE2");
            message.getMessageProperties().setExpiration("6000");
            return message;
        });
    }





}
