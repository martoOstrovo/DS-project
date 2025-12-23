package apm.ds.auctionservice.annotation;

import apm.ds.auctionservice.annotation.validator.IsNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNumber {
    String value() default "^[+-]?\\d+(\\.\\d+)?$";
    String message() default "Please enter a number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
