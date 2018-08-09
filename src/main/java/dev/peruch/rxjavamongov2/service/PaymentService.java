package dev.peruch.rxjavamongov2.service;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;
import dev.peruch.rxjavamongov2.controller.response.PaymentResponse;
import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class PaymentService {

    public void sendPayment(BaseEntity payment){
        TransacaoSubject
                .getTransacaoSubject()
                .onNext(payment);
    }

    public BaseEntity buildEvent(PaymentDto paymentDto){
        return new Payment(new Date(),
                            generateIdTransaction(),
                            "ACCEPTED PAYMENT",
                            paymentDto);
    }

    public PaymentResponse buildResponse(BaseEntity paymentEvent){
        return new PaymentResponse("0",
                                    "OK",
                                    paymentEvent.getIdTransaction());
    }

    private String generateIdTransaction(){
        return String.valueOf(new Random().nextInt(5000));
    }
}
