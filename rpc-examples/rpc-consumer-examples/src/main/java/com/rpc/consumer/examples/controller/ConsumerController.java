package com.rpc.consumer.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rpc.api.examples.service.EchoService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

//    @DubboReference
    private EchoService echoService;

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable String message) {
        return echoService.echo(message);
    }
}
