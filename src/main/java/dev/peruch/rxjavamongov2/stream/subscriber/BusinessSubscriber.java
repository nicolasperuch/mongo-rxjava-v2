package dev.peruch.rxjavamongov2.stream.subscriber;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.Payment;
import dev.peruch.rxjavamongov2.entity.PaymentExternalResponse;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class BusinessSubscriber {

    private BusinessSubscriber() {
        TransacaoSubject
                .getTransacaoSubject()
                .filter(e -> isPaymentAccepted(e))
                .subscribe(e -> TransacaoSubject
                                        .getTransacaoSubject()
                                        .onNext(callExternalService(e)));
    }

    public Boolean isPaymentAccepted(Object baseEntity){
        BaseEntity event = (BaseEntity) baseEntity;
        return event.getStatus().equalsIgnoreCase("ACCEPTED PAYMENT");
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
