package dev.peruch.rxjavamongov2.stream.subscriber;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.entity.PaymentExternalResponse;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class PaymentSubscriber {

    private PaymentSubscriber() {
        TransacaoSubject
                .getTransacaoSubject()
                .filter(e -> isPaymentAccepted(e))
                .subscribe(e -> {
                    TransacaoSubject
                            .getTransacaoSubject()
                            .onNext(changeActualStatus(e));

                    TransacaoSubject
                            .getTransacaoSubject()
                            .onNext(callExternalService(e));
                });
    }

    public Boolean isPaymentAccepted(Object baseEntity){
        BaseEntity event = (BaseEntity) baseEntity;
        return event.getStatus().equalsIgnoreCase("ACCEPTED PAYMENT");
    }

    public BaseEntity changeActualStatus(Object event){
        Payment payment = new Payment(new Date(), ((Payment)event).getIdTransaction(), "PAYMENT IN PROGRESS");
        payment.setCpf(((Payment)event).getCpf());
        payment.setDate(((Payment)event).getDate());
        payment.setNsa(((Payment)event).getNsa());
        payment.setSpecialCode(((Payment)event).getSpecialCode());
        payment.setValue(((Payment)event).getValue());
        return payment;
    }

    public PaymentExternalResponse callExternalService(Object baseEntity){
        //call external services here
        PaymentExternalResponse response = new PaymentExternalResponse(new Date(),
                                    ((Payment) baseEntity).getIdTransaction(),
                                    "COMPLETED PAYMENT" );
        response.setAmountEstablishments(new BigDecimal(7));
        response.setNsa(((Payment) baseEntity).getNsa());
        response.setProcessedCode("8411022");
        response.setTerminalDate("10052018");
        response.setTerminalReq("15052018");
        response.setTransactionValue(new BigDecimal(((Payment) baseEntity).getValue()));
        return response;
    }
}
