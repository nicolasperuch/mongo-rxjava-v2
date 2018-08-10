package dev.peruch.rxjavamongov2.stream.subscriber;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.entity.ReversalExternalResponse;
import dev.peruch.rxjavamongov2.service.ReversalService;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ReversalSubscriber {

    @Autowired
    ReversalService reversalService;

    private ReversalSubscriber() {
        TransacaoSubject
                .getTransacaoSubject()
                .filter(e -> isReversalAccepted(e))
                .subscribe(e -> {
                    TransacaoSubject
                            .getTransacaoSubject()
                            .onNext(changeActualStatus(e));

                    TransacaoSubject
                            .getTransacaoSubject()
                            .onNext(callExternalService(e));
                });
    }

    public Boolean isReversalAccepted(Object baseEntity){
        BaseEntity event = (BaseEntity) baseEntity;
        return event.getStatus().equalsIgnoreCase("ACCEPTED REVERSAL");
    }

    private BaseEntity changeActualStatus(Object baseEntity) {
        return reversalService.buildEvent((BaseEntity) baseEntity, "REVERSAL IN PROGRESS");
    }

    private BaseEntity callExternalService(Object e) {
        //call external services here and return it to stream;
        ReversalExternalResponse reversal = new ReversalExternalResponse(new Date(),((BaseEntity) e).getIdTransaction(), "COMPLETED REVERSAL");
        reversal.setLoseAmount("100.21");
        reversal.setTax("3%");
        return reversal;
    }
}
