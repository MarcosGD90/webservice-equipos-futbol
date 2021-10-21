package com.mgd.equipos.futbol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mgd.equipos.futbol.domain.FootballTeam;

public interface FootballTeamRepository extends JpaRepository<FootballTeam, Long> {

}
