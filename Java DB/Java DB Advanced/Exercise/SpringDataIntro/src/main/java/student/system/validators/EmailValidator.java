package student.system.validators;

import student.system.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */
public class EmailValidator implements ConstraintValidator<Email, CharSequence> {
    private static final String USER_PATTERN = "^(?<![.\\-_])[A-Za-z0-9]+[A-Za-z0-9.\\-_]*[A-Za-z0-9]+(?![.\\-_])$";
    private static final String HOST_WORDS_PATTERN = "^([A-Za-z]+[A-Za-z\\-]*[A-Za-z]+)$";

    @Override
    public void initialize(Email password) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {

        String email = "";

        for (int i = 0; i < charSequence.length(); i++) {
            email += String.valueOf(charSequence.charAt(i));
        }

        if (!email.contains("@")) {
            return false;
        }

        String[] emailTokens = email.split("@");

        if(!emailTokens[0].matches(USER_PATTERN)) {
            return false;
        }

        if (!emailTokens[1].contains(".")) {
            return false;
        }

        String[] hostTokens = emailTokens[1].split(".");

        for (String hostToken : hostTokens) {
            if (!hostToken.matches(HOST_WORDS_PATTERN)) {
                return false;
            }
        }

        return true;
    }
}