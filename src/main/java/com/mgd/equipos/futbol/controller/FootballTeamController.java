package com.mgd.equipos.futbol.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgd.equipos.futbol.dto.FootballTeamDto;
import com.mgd.equipos.futbol.service.FootballTeamService;

import lombok.RequiredArgsConstructor;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/footballteam")
public class FootballTeamController {

	private final FootballTeamService footballTeamService;

	private final Logger LOGGER = LoggerFactory.getLogger(FootballTeamController.class);

	@GetMapping("/{id}")
	public ResponseEntity<FootballTeamDto> getTeamById(@RequestParam Long id) {

		LOGGER.info("Getting football team with id: " + id);
		FootballTeamDto footballTeam = footballTeamService.findFootballTeamById(id);
		LOGGER.info("Football team with id: " + id + ", found.");
		return ResponseEntity.ok(footballTeam);
	}

	@GetMapping
	public ResponseEntity<List<FootballTeamDto>> getAllTeams() {

		LOGGER.info("Getting all football teams.");
		List<FootballTeamDto> footballTeamList = footballTeamService.findAllFootballTeam();
		LOGGER.info("Have be found " + footballTeamList.size() + " football teams.");
		return ResponseEntity.ok(footballTeamList);
	}

	@PostMapping
	public ResponseEntity<String> createTeam(@Valid @RequestBody FootballTeamDto footballTeam) {

		LOGGER.info("Creating a new football team.");
		Long entityId = footballTeamService.createFootballTeam(footballTeam);
		LOGGER.info("Football team created with id: " + entityId);
		return ResponseEntity.ok("id: ".concat(String.valueOf(entityId)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTeamById(@RequestParam Long id) {

		HttpStatus status = HttpStatus.NO_CONTENT;
		LOGGER.info("Deleting football team with id: " + id);
		boolean deleted = footballTeamService.deleteFootballTeam(id);
		if (!deleted) {
			status = HttpStatus.NOT_FOUND;
			LOGGER.error("Football team with id: " + id + ", not found.");
		} else {
			LOGGER.info("Football team with id: " + id + ", deleted.");
		}
		return ResponseEntity.status(status)
		        .build();
	}

	@PatchMapping
	public ResponseEntity<String> updateTeam(@Valid @RequestBody FootballTeamDto footballTeam) {

		HttpStatus status = HttpStatus.NO_CONTENT;
		LOGGER.info("Updating a football team with id " + footballTeam.getId());
		boolean updated = footballTeamService.updateFootballTeam(footballTeam);
		if (!updated) {
			status = HttpStatus.NOT_FOUND;
			LOGGER.error("Football team with id: " + footballTeam.getId() + ", not found.");
		} else {
			LOGGER.info("Football team with id: " + footballTeam.getId() + ", updated.");
		}
		return ResponseEntity.status(status)
		        .build();
	}
}
