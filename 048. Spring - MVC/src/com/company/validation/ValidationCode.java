package com.company.validation;

import javax.validation.Constraint;
import javax.validation.Payload;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = ValidationCodeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidationCode {

	public String value() default "88";
	public String message() default "Incorect value";
	public Class<?>[] groups() default {};
	public Class<? extends Payload>[] payload() default {};
}