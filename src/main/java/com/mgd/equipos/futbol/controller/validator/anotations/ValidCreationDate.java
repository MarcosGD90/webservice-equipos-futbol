package com.mgd.equipos.futbol.controller.validator.anotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mgd.equipos.futbol.controller.validator.CreationDateValidator;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CreationDateValidator.class)
@Documented
public @interface ValidCreationDate {

	String message() default "Error al validar la fecha de creación, debe ser anterior a la actual";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
