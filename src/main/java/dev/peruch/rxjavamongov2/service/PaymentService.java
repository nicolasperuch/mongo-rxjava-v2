package dev.peruch.rxjavamongov2.service;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;
import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {

    public void sendPayment(PaymentDto paymentDto){
        TransacaoSubject
                .getTransacaoSubject()
                .onNext(buildEvent(paymentDto));
    }

    public BaseEntity buildEvent(PaymentDto paymentDto){
        return new Payment(new Date(),"10","ACCEPTED PAYMENT", paymentDto);
    }
}
