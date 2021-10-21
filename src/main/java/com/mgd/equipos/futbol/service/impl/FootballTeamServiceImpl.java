package com.mgd.equipos.futbol.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mgd.equipos.futbol.domain.FootballTeam;
import com.mgd.equipos.futbol.dto.FootballTeamDto;
import com.mgd.equipos.futbol.mapper.FootballTeamMapper;
import com.mgd.equipos.futbol.repository.FootballTeamRepository;
import com.mgd.equipos.futbol.service.FootballTeamService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FootballTeamServiceImpl implements FootballTeamService {

	private final FootballTeamRepository footballTeamRepository;
	private final FootballTeamMapper footballTeamMapper;

	@Override
	public FootballTeamDto findFootballTeamById(Long id) {
		return footballTeamMapper.toDto(footballTeamRepository.findById(id)
		        .orElse(null));
	}

	@Override
	public List<FootballTeamDto> findAllFootballTeam() {
		return footballTeamMapper.toDto(footballTeamRepository.findAll());
	}

	@Override
	public Long createFootballTeam(FootballTeamDto footballTeam) {
		return footballTeamRepository.save(footballTeamMapper.toEntity(footballTeam))
		        .getId();
	}

	@Override
	public boolean updateFootballTeam(FootballTeamDto footballTeamDto) {

		boolean updated = false;
		FootballTeam footballTeam = footballTeamMapper.toEntity(footballTeamDto);
		Optional<FootballTeam> footballTeamToUpdate = footballTeamRepository.findById(footballTeam.getId());

		if (footballTeamToUpdate.isPresent()) {
			footballTeamRepository.save(footballTeam);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean deleteFootballTeam(Long id) {

		boolean deleted = false;
		Optional<FootballTeam> footballTeam = (footballTeamRepository.findById(id));

		if (footballTeam.isPresent()) {
			footballTeamRepository.deleteById(id);
			deleted = true;
		}
		return deleted;
	}
}
