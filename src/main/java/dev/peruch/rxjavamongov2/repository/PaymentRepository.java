package dev.peruch.rxjavamongov2.repository;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<BaseEntity, String> {
    BaseEntity save(BaseEntity baseEntity);
}
