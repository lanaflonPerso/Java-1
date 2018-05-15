package game.validators;

import game.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */
public class EmailValidator implements ConstraintValidator<Email, CharSequence> {

    @Override
    public void initialize(Email password) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {

        String email = "";

        for (int i = 0; i < charSequence.length(); i++) {
            email += String.valueOf(charSequence.charAt(i));
        }

        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        return true;
    }
}