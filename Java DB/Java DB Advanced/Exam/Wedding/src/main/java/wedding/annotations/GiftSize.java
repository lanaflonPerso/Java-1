package wedding.annotations;

import wedding.validators.GiftSizeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GiftSizeValidator.class})
@Documented
public @interface GiftSize {

    String message() default "Incorrect giftSize";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
