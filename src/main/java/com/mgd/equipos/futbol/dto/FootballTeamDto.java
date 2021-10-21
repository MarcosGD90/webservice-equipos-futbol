package com.mgd.equipos.futbol.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.mgd.equipos.futbol.controller.validator.anotations.ValidCreationDate;
import com.mgd.equipos.futbol.controller.validator.anotations.ValidDivisionCapacity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ValidDivisionCapacity
public class FootballTeamDto {

	private Long id;
	@NotBlank
	private String name;
	private String city;
	private String owner;
	private Integer stadiumCapacity;
	private Integer division;
	private String competition;
	@Min(1)
	private Integer numerOfPlayers;
	@ValidCreationDate
	private LocalDateTime creationDate;

}
