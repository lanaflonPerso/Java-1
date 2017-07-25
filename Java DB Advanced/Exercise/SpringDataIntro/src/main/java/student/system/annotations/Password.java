package student.system.annotations;

import student.system.validators.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
@Documented
public @interface Password {

    String message() default "Incorrect password, please try again";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int minLength() default 6;

    int maxLength() default 50;

    boolean hasUpperLetter() default true;

    boolean hasLowerLetter() default true;

    boolean hasDigit() default true;

    boolean hasSpecialSysmbol() default true;
}