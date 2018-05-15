package photography.annotations;

import photography.validators.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PhoneValidator.class})
@Documented
public @interface Phone {

    String message() default "Incorrect phone";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}