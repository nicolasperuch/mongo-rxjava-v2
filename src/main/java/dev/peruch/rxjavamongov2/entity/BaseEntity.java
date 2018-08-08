package dev.peruch.rxjavamongov2.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "events")
public abstract class BaseEntity {

    @Id
    private String id;
    private Date creationDate;
    private String idTransaction;
    private String status;

    public BaseEntity(String id, Date creationDate, String idTransaction, String status) {
        this.id = id;
        this.creationDate = creationDate;
        this.idTransaction = idTransaction;
        this.status = status;
    }
}
