package com.example.api.controller;

import com.example.api.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbit")
public class RabbitMqController {

    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping("direct")
    public void direct() {
        rabbitMQProducer.enviarMensagem("TESTE: 'Teste'");
    }


}
