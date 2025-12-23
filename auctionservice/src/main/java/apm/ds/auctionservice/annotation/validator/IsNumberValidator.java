package apm.ds.auctionservice.annotation.validator;

import apm.ds.auctionservice.annotation.IsNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsNumberValidator implements ConstraintValidator<IsNumber, String> {
    private Pattern pattern;

    @Override
    public void initialize(IsNumber constraintAnnotation) {
        pattern = Pattern.compile(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = pattern.matcher(s);
        return matcher.matches();
    }
}
