package dev.peruch.rxjavamongov2.entity;

import dev.peruch.rxjavamongov2.controller.dto.PaymentDto;

import java.util.Date;

public class Payment extends BaseEntity{

    private String specialCode;
    private String cpf;
    private String nsa;
    private String date;
    private String value;

    public Payment(Date creationDate, String idTransaction, String status, PaymentDto paymentDto) {
        super(creationDate, idTransaction, status);
        this.specialCode = paymentDto.getSpecialCode();
        this.cpf = paymentDto.getCpf();
        this.nsa = paymentDto.getNsa();
        this.date = paymentDto.getDate();
        this.value = paymentDto.getValue();
    }

    public String getNsa() {
        return nsa;
    }

    public String getValue() {
        return value;
    }
}
