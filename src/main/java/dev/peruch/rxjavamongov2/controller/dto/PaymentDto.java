package dev.peruch.rxjavamongov2.controller.dto;

import java.util.Date;

public class PaymentDto {

    private String specialCode;
    private String cpf;
    private String nsa;
    private Date date;
    private String value;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
