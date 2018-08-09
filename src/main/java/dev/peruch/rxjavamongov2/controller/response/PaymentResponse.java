package dev.peruch.rxjavamongov2.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {

    private String code;
    private String status;
    private String idTransaction;

    public PaymentResponse(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public PaymentResponse(String code, String status, String idTransaction) {
        this.code = code;
        this.status = status;
        this.idTransaction = idTransaction;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
