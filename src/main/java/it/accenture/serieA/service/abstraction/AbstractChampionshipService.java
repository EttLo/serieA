package it.accenture.serieA.service.abstraction;

import java.util.List;
import java.util.Optional;

import it.accenture.serieA.model.Match;
import it.accenture.serieA.model.Player;
import it.accenture.serieA.model.Team;

public interface AbstractChampionshipService {
    List<Player> findPlayersByTeamName(String teamName);

    List<Player> findPlayersByGoalGreaterThan(int nGoals);

    List<Player> findPlayersByJerseyNumber(int jerseyN);

    List<Player> findPlayersByDobAfter(String dob);

    List<Player> findPlayersBySurname(String surname);

    List<Player> findPlayersByPosition(String position);

    List<Team> findAllTeams();

    Optional<Team> findTeamById(Long id);

    List<Match> findMatchByMatchDate(String matchDate);

    List<Match> findMatchByTeamHomeName(String teamName);

    List<Match> findMatchByTeamAwayName(String teamName);

    List<Match> findMatchByTeamHomeNameOrTeamAwayName(String teamName, String tName);

    List<Match> findMatchByChampionshipStartYear(int year);

    List<Match> findMatchByGoalCountGreaterThan(int nGoals);

}
