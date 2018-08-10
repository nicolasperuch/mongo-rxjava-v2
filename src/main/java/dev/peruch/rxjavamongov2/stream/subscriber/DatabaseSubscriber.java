package dev.peruch.rxjavamongov2.stream.subscriber;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import dev.peruch.rxjavamongov2.repository.BaseRepository;
import dev.peruch.rxjavamongov2.stream.TransacaoSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSubscriber {

    @Autowired
    BaseRepository baseRepository;

    private DatabaseSubscriber() {
        TransacaoSubject
                .getTransacaoSubject()
                .subscribe(e -> baseRepository.save((BaseEntity) e));
    }
}
