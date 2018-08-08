package dev.peruch.rxjavamongov2.stream;

import org.springframework.stereotype.Component;
import rx.subjects.PublishSubject;

import javax.annotation.PostConstruct;

@Component
public class TransacaoSubject {

    private static PublishSubject transacaoSubject;

    @PostConstruct
    public void bootstrap() {
        this.transacaoSubject = PublishSubject.create();
    }

    public static PublishSubject getTransacaoSubject() {
        return transacaoSubject;
    }

}

