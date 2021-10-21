package com.mgd.equipos.futbol.controller.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mgd.equipos.futbol.controller.validator.anotations.ValidDivisionCapacity;
import com.mgd.equipos.futbol.dto.FootballTeamDto;

public class DivisionCapacityValidator implements ConstraintValidator<ValidDivisionCapacity, FootballTeamDto> {
	@Override
	public boolean isValid(FootballTeamDto footballTeamDto, ConstraintValidatorContext context) {

		boolean isValid = true;

		if (footballTeamDto.getDivision()
		        .equals(1) && footballTeamDto.getStadiumCapacity() < 50000) {

			isValid = false;

		} else if ((footballTeamDto.getDivision()
		        .equals(2) && footballTeamDto.getStadiumCapacity() < 10000)) {

			isValid = false;

		} else if ((footballTeamDto.getDivision()
		        .equals(3) && footballTeamDto.getStadiumCapacity() < 3000)) {
			isValid = false;
		}

		return isValid;
	}
}
