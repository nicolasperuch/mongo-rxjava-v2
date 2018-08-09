package dev.peruch.rxjavamongov2.service;

import dev.peruch.rxjavamongov2.controller.response.PaymentResponse;
import dev.peruch.rxjavamongov2.validator.annotation.Evaluate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Field;

@Service
public class HandlerExceptionService {

    public PaymentResponse buildErrorMessage(Class targetClass, MethodArgumentNotValidException ex) throws NoSuchFieldException {
        Field f = targetClass.getDeclaredField(ex.getBindingResult().getFieldError().getField());
        Evaluate anno = f.getAnnotation(Evaluate.class);
        return new PaymentResponse(anno.codigo(), anno.message());
    }
}
