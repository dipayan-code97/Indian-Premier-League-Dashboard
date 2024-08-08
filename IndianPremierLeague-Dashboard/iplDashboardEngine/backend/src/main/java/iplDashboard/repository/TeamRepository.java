package iplDashboard.repository;

import org.springframework.data.repository.CrudRepository;

import iplDashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long>  {

    Team findByTeamName(String teamName);
}
