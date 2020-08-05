package com.example.api.controller;

import com.example.api.service.RabbitMqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rabbit")
public class RabbitMqController {

    private final RabbitMqService rabbitMqService;

    @GetMapping("direct")
    public void direct(){
        rabbitMqService.direct();
    }

    @GetMapping("fanout")
    public void fanout(){
        rabbitMqService.fanout();
    }

    @GetMapping("topic/{key}")
    public void topic(@PathVariable String key){
        rabbitMqService.topic(key);
    }

    @GetMapping("header/{valor}")
    public void header(@PathVariable String valor){
        rabbitMqService.header(valor);
    }

}
