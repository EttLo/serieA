package it.accenture.serieA.service.abstraction;

import java.time.LocalDate;
import java.util.List;

import it.accenture.serieA.model.Player;
import it.accenture.serieA.model.Team;

public interface AbstractChampionshipService {
    List<Player> findPlayersByTeamName(String teamName);
    List<Player> findPlayersByGoalGreaterThan(int nGoals);
    List<Player> findPlayersByJerseyNumber(int jerseyN);
    List<Player> findPlayersByDobAfter(String dob);
    List<Player> findPlayersBySurname(String surname);
    List<Player> findPlayersByPosition(String position);
    List<Team> findAllTeams ();
}
