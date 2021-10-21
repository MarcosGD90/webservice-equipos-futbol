package com.mgd.equipos.futbol.controller.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.mgd.equipos.futbol.controller")
public class TeamHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handlerValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult()
		        .getAllErrors()
		        .forEach(error -> {
			        String fieldName = null;
			        if (error instanceof FieldError) {
				        fieldName = ((FieldError) error).getField();
			        } else {
				        fieldName = ((ObjectError) error).getObjectName();
			        }
			        errors.put(fieldName, error.getDefaultMessage());
		        });
		return errors;
	}
}
