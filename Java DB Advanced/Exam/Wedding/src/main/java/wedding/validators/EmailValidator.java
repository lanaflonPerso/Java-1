package wedding.validators;

import wedding.annotations.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, CharSequence> {
    private static final String USER_PATTERN = "[A-Za-z0-9]+";
    private static final String HOST_PATTERN = "[a-z]+\\.[a-z]+";

    @Override
    public void initialize(Email email) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        String email = String.valueOf(charSequence);

        if (charSequence == null) {
            return true;
        }

        if (!email.contains("@")) {
            return false;
        }

        String[] emailTokens = email.split("@");

        return emailTokens.length == 2 && emailTokens[0].matches(USER_PATTERN) && emailTokens[1].matches(HOST_PATTERN);

    }
}
