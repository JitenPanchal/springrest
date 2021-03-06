package com.springrest.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EntityIdValidator implements ConstraintValidator<EntityId, Long> {

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {

		if (value == null)
			return true;

		return value >= 1 && value <= Long.MAX_VALUE;
	}

}