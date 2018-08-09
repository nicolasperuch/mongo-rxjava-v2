package dev.peruch.rxjavamongov2.controller;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;
import dev.peruch.rxjavamongov2.controller.response.PaymentResponse;
import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.service.HandlerExceptionService;
import dev.peruch.rxjavamongov2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class Controller {

    @Autowired
    PaymentService paymentService;

    @Autowired
    HandlerExceptionService handlerExceptionService;

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @PostMapping("/payment")
    public PaymentResponse payment(@RequestBody @Valid PaymentDto paymentDto){
        BaseEntity paymentEvent = paymentService.buildEvent(paymentDto);
        paymentService.sendPayment(paymentEvent);
        return paymentService.buildResponse(paymentEvent);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public PaymentResponse handleValidationExceptions(MethodArgumentNotValidException ex) throws NoSuchMethodException, NoSuchFieldException {
        return handlerExceptionService.buildErrorMessage(new PaymentDto().getClass(), ex);
    }
}