package dev.peruch.rxjavamongov2.entity;

import java.util.Date;

public class ReversalExternalResponse extends BaseEntity{

    private String tax;
    private String loseAmount;

    public ReversalExternalResponse() {}

    public ReversalExternalResponse(Date creationDate, String idTransaction, String status) {
        super(creationDate, idTransaction, status);
    }

    public ReversalExternalResponse(Date creationDate, String idTransaction, String status, String tax, String loseAmount) {
        super(creationDate, idTransaction, status);
        this.tax = tax;
        this.loseAmount = loseAmount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getLoseAmount() {
        return loseAmount;
    }

    public void setLoseAmount(String loseAmount) {
        this.loseAmount = loseAmount;
    }
}
