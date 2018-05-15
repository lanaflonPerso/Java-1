package game.validators;

import game.annotations.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */
public class PasswordValidator implements ConstraintValidator<Password, CharSequence> {

    private int minLength;
    private boolean hasUpper;
    private boolean hasLower;
    private boolean hasDigit;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.hasUpper = password.hasUpperLetter();
        this.hasLower = password.hasLowerLetter();
        this.hasDigit = password.hasDigit();
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {

        if (charSequence == null || charSequence.length() < this.minLength) {
            return false;
        }

        boolean upper = false;
        boolean lower = false;
        boolean digit = false;

        if (this.hasUpper) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (Character.isUpperCase(charSequence.charAt(i))) {
                    upper = true;
                    break;
                }
            }
        } else {
            upper = true;
        }

        if (this.hasLower) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (Character.isLowerCase(charSequence.charAt(i))) {
                    lower = true;
                    break;
                }
            }
        } else {
            lower = true;
        }

        if (this.hasDigit) {
            for (int i = 0; i < charSequence.length(); i++) {
                if (Character.isDigit(charSequence.charAt(i))) {
                    digit = true;
                    break;
                }
            }
        } else {
            digit = true;
        }

        return upper && lower && digit;
    }
}
