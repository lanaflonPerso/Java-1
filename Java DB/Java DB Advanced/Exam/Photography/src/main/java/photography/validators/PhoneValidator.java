package photography.validators;

import photography.annotations.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, CharSequence> {
    @Override
    public void initialize(Phone phone) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        String phone = String.valueOf(charSequence);
        if (charSequence == null) {
            return true;
        }
        return phone.matches("\\+\\d{1,3}\\/\\d{8,10}");

    }
}
