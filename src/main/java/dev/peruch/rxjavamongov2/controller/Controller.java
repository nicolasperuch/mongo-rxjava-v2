package dev.peruch.rxjavamongov2.controller;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;
import dev.peruch.rxjavamongov2.controller.response.PaymentResponse;
import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.entity.PaymentExternalResponse;
import dev.peruch.rxjavamongov2.service.HandlerExceptionService;
import dev.peruch.rxjavamongov2.service.PaymentService;
import dev.peruch.rxjavamongov2.service.ReversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class Controller {

    @Autowired
    PaymentService paymentService;

    @Autowired
    ReversalService reversalService;

    @Autowired
    HandlerExceptionService handlerExceptionService;

    @GetMapping("/")
    public String home(){
        return "Home";
    }

    @PostMapping("/payment")
    public PaymentResponse paymentRequest(@RequestBody @Valid PaymentDto paymentDto){
        BaseEntity paymentEvent = paymentService.buildEvent(paymentDto);
        paymentService.sendPayment(paymentEvent);
        return paymentService.buildResponse(paymentEvent);
    }

    @PutMapping("/reversal/{idTransaction}")
    public PaymentResponse reversalRequest(@PathVariable String idTransaction) {

        BaseEntity baseEntity = reversalService.findByIdTransaction(idTransaction);

        if (Objects.isNull(baseEntity)) {
            return new PaymentResponse("-1", "ERROR", idTransaction);
        } else if(baseEntity.getStatus().equalsIgnoreCase("REVERSAL ACCEPTED")){
            return new PaymentResponse("-1", "REVERSAL WAS ALREADY REQUEST FOR THIS TRANSACTION", idTransaction);
        }

        BaseEntity event = reversalService.buildEvent(baseEntity, "ACCEPTED REVERSAL");
        reversalService.sendReversal(event);
        return new PaymentResponse("0", "OK", idTransaction);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public PaymentResponse handleValidationExceptions(MethodArgumentNotValidException ex) throws NoSuchMethodException, NoSuchFieldException {
        return handlerExceptionService.buildErrorMessage(new PaymentDto().getClass(), ex);
    }
}