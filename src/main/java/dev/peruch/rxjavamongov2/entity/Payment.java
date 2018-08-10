package dev.peruch.rxjavamongov2.entity;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;

import java.util.Date;

public class Payment extends BaseEntity{

    private String specialCode;
    private String cpf;
    private String nsa;
    private String date;
    private String value;


    public Payment(){}

    public Payment(Date creationDate, String idTransaction, String status) {
        super(creationDate, idTransaction, status);
    }

    public Payment(Date creationDate, String idTransaction, String status, PaymentDto paymentDto) {
        super(creationDate, idTransaction, status);
        this.specialCode = paymentDto.getSpecialCode();
        this.cpf = paymentDto.getCpf();
        this.nsa = paymentDto.getNsa();
        this.date = paymentDto.getDate();
        this.value = paymentDto.getValue();
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNsa() {
        return nsa;
    }

    public void setNsa(String nsa) {
        this.nsa = nsa;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
