package dev.peruch.rxjavamongov2.controller;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;
import dev.peruch.rxjavamongov2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @PostMapping("/payment")
    public String payment(@RequestBody PaymentDto paymentDto){

        paymentService.sendPayment(paymentDto);

        return "working";
    }


}