package dev.peruch.rxjavamongov2.service;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.entity.PaymentExternalResponse;
import dev.peruch.rxjavamongov2.repository.BaseRepository;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReversalService {

    @Autowired
    BaseRepository baseRepository;

    public void sendReversal(BaseEntity reversal){
        TransacaoSubject
                .getTransacaoSubject()
                .onNext(reversal);
    }

    public BaseEntity findByIdTransaction(String idTransaction) {
        return baseRepository.findByIdTransactionOrderByCreationDateDesc(idTransaction).get(0);
    }

    public BaseEntity buildEvent(BaseEntity baseEntity, String status){
        String className = baseEntity.getClass().getSimpleName();
        BaseEntity event = className.equalsIgnoreCase("Payment") ?
                buildPayment((Payment) baseEntity, status) :
                buildPaymentExternalResponse((PaymentExternalResponse) baseEntity, status);
        return event;
    }

    public BaseEntity buildPayment(Payment payment, String status){
        Payment event = new Payment(new Date(), payment.getIdTransaction(),status);
        event.setValue(payment.getValue());
        event.setSpecialCode(payment.getSpecialCode());
        event.setNsa(payment.getNsa());
        event.setDate(payment.getDate());
        event.setCpf(payment.getCpf());
        return event;
    }

    public BaseEntity buildPaymentExternalResponse(PaymentExternalResponse payment, String status){
        PaymentExternalResponse event = new PaymentExternalResponse(new Date(), payment.getIdTransaction(), status);
        event.setAmountEstablishments(payment.getAmountEstablishments());
        event.setNsa(payment.getNsa());
        event.setProcessedCode(payment.getProcessedCode());
        event.setTerminalDate(payment.getTerminalDate());
        event.setTerminalReq(payment.getTerminalReq());
        event.setTransactionValue(payment.getTransactionValue());
        return event;
    }
}
