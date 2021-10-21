package com.mgd.equipos.futbol.service;

import java.util.List;

import com.mgd.equipos.futbol.dto.FootballTeamDto;

public interface FootballTeamService {

	public FootballTeamDto findFootballTeamById(Long id);

	public List<FootballTeamDto> findAllFootballTeam();

	public Long createFootballTeam(FootballTeamDto footballTeam);

	public boolean updateFootballTeam(FootballTeamDto footballTeam);

	public boolean deleteFootballTeam(Long id);

}
