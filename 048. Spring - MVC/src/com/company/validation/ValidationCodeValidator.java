package com.company.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidationCodeValidator implements ConstraintValidator<ValidationCode, String> {

	private String validationCodePrefix;

	@Override
	public void initialize(ValidationCode validationCode) {
		validationCodePrefix = validationCode.value();
	}

	@Override
	public boolean isValid(String string, ConstraintValidatorContext constraintValidatorContext) {
		if (string != null) {
			return string.startsWith(this.validationCodePrefix);
		} else {
			return true;
		}
	}
}