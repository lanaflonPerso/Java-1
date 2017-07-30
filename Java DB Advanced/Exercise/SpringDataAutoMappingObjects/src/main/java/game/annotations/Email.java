package game.annotations;

import game.validators.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EmailValidator.class})
@Documented
public @interface Email {

    String message() default "Incorrect email, please try again";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}