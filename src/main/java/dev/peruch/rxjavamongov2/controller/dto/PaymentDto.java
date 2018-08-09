package dev.peruch.rxjavamongov2.controller.dto;

import dev.peruch.rxjavamongov2.validator.annotation.Evaluate;

public class PaymentDto {

    @Evaluate(codigo = "1", message = "Invalid special code")
    private String specialCode;
    @Evaluate(codigo = "2", message = "Invalid cpf")
    private String cpf;
    @Evaluate(codigo = "3", message = "Invalid nsa")
    private String nsa;
    @Evaluate(codigo = "4", message = "Invalid date")
    private String date;
    @Evaluate(codigo = "5", message = "Invalid value")
    private String value;

    public String getSpecialCode() {
        return specialCode;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNsa() {
        return nsa;
    }

    public String getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

}
