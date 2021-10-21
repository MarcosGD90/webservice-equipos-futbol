package com.mgd.equipos.futbol.controller.validator;

import java.time.LocalDateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mgd.equipos.futbol.controller.validator.anotations.ValidCreationDate;

public class CreationDateValidator implements ConstraintValidator<ValidCreationDate, LocalDateTime> {

	@Override
	public boolean isValid(LocalDateTime date, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (!date.isBefore(LocalDateTime.now())) {
			isValid = false;
		}
		return isValid;
	}
}
