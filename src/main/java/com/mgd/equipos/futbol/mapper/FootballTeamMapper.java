package com.mgd.equipos.futbol.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.mgd.equipos.futbol.domain.FootballTeam;
import com.mgd.equipos.futbol.dto.FootballTeamDto;

@Mapper
public interface FootballTeamMapper {

	FootballTeam toEntity(FootballTeamDto dto);

	FootballTeamDto toDto(FootballTeam entity);

	List<FootballTeamDto> toDto(List<FootballTeam> entity);

}
