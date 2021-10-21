package com.mgd.equipos.futbol.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FootballTeam	")
public class FootballTeam implements Serializable {

	@Id
	@GeneratedValue(generator = "sequence",
	        strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sequence",
	        allocationSize = 1)
	private Long id;
	private String name;
	private String city;
	private String owner;
	private Integer stadiumCapacity;
	private Integer division;
	private String competition;
	private Integer numerOfPlayers;
	private LocalDateTime creationDate;

}
