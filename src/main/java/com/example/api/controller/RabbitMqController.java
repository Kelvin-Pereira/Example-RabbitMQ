package com.example.api.controller;

import com.example.api.service.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbit")
public class RabbitMqController {

    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping("direct")
    public void direct(){
        rabbitMQProducer.enviarMensagem("TESTE: 'Teste'");
    }


}
