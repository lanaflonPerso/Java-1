package wedding.validators;

import wedding.annotations.GiftSize;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GiftSizeValidator implements ConstraintValidator<GiftSize, CharSequence> {
    @Override
    public void initialize(GiftSize giftSize) {
    }

    @Override
    public boolean isValid(CharSequence charSequence, ConstraintValidatorContext constraintValidatorContext) {
        String giftSize = String.valueOf(charSequence);
        return giftSize.equals("Small") || giftSize.equals("Medium") || giftSize.equals("Large") || giftSize.equals("Not Specified");
    }
}
