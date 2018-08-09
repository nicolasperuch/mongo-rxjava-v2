package dev.peruch.rxjavamongov2.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PaymentResponse extends BaseEntity {

    private String nsa;
    private String processedCode;
    private BigDecimal transactionValue;
    private BigDecimal amountEstablishments;
    private String terminalDate;
    private String terminalReq;

    public PaymentResponse(Date creationDate, String idTransaction, String status) {
        super(creationDate, idTransaction, status);
    }

    public String getNsa() {
        return nsa;
    }

    public void setNsa(String nsa) {
        this.nsa = nsa;
    }

    public String getProcessedCode() {
        return processedCode;
    }

    public void setProcessedCode(String processedCode) {
        this.processedCode = processedCode;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public BigDecimal getAmountEstablishments() {
        return amountEstablishments;
    }

    public void setAmountEstablishments(BigDecimal amountEstablishments) {
        this.amountEstablishments = amountEstablishments;
    }

    public String getTerminalDate() {
        return terminalDate;
    }

    public void setTerminalDate(String terminalDate) {
        this.terminalDate = terminalDate;
    }

    public String getTerminalReq() {
        return terminalReq;
    }

    public void setTerminalReq(String terminalReq) {
        this.terminalReq = terminalReq;
    }
}
