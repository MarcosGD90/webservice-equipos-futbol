package com.mgd.equipos.futbol.controller.validator.anotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.mgd.equipos.futbol.controller.validator.DivisionCapacityValidator;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DivisionCapacityValidator.class)
@Documented
public @interface ValidDivisionCapacity {

	String message() default "Error al validar la capacidad del estadio. No es la correcta para esta division";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
