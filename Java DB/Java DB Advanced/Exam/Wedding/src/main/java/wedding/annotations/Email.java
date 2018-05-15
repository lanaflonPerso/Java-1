package wedding.annotations;

import wedding.validators.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
@Documented
public @interface Email {

    String message() default "Incorrect email";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
