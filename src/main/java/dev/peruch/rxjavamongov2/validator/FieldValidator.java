package dev.peruch.rxjavamongov2.validator;

import dev.peruch.rxjavamongov2.validator.annotation.Evaluate;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class FieldValidator implements ConstraintValidator<Evaluate, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null;
    }
}
