package dev.peruch.rxjavamongov2.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentExternalResponse extends BaseEntity {

    private String nsa;
    private String processedCode;
    private BigDecimal transactionValue;
    private BigDecimal amountEstablishments;
    private String terminalDate;
    private String terminalReq;

    public PaymentExternalResponse(Date creationDate, String idTransaction, String status) {
        super(creationDate, idTransaction, status);
    }

    public void setNsa(String nsa) {
        this.nsa = nsa;
    }

    public void setProcessedCode(String processedCode) {
        this.processedCode = processedCode;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public void setAmountEstablishments(BigDecimal amountEstablishments) {
        this.amountEstablishments = amountEstablishments;
    }

    public void setTerminalDate(String terminalDate) {
        this.terminalDate = terminalDate;
    }

    public void setTerminalReq(String terminalReq) {
        this.terminalReq = terminalReq;
    }
}
