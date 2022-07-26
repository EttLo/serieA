package it.accenture.serieA.service.abstraction;

import java.util.List;

import it.accenture.serieA.model.Player;

public interface AbstractChampionshipService {
    List<Player> findPlayersByTeamName(String teamName);

    List<Player> findPlayersByGoalGreaterThan(int nGoals);
}
