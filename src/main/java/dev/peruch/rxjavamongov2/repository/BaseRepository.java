package dev.peruch.rxjavamongov2.repository;

import dev.peruch.rxjavamongov2.entity.BaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BaseRepository extends MongoRepository<BaseEntity, String> {
    BaseEntity save(BaseEntity baseEntity);
    List<BaseEntity> findByIdTransactionOrderByCreationDateDesc(String idTransacion);
}
