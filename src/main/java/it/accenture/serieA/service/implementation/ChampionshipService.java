package it.accenture.serieA.service.implementation;

import java.time.LocalDate;
import java.util.List;

import it.accenture.serieA.model.Team;
import it.accenture.serieA.repository.abstraction.TeamRepository;
import org.springframework.stereotype.Service;

import it.accenture.serieA.model.Player;
import it.accenture.serieA.repository.abstraction.PlayerRepository;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;

@Service
public class ChampionshipService implements AbstractChampionshipService {
    private PlayerRepository playerRepo;
    private TeamRepository teamRepo;

    public ChampionshipService(PlayerRepository pr, TeamRepository tr) {
        this.playerRepo = pr;
        this.teamRepo=tr;
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) {
        return playerRepo.findByTeamName(teamName);
    }

    @Override
    public List<Player> findPlayersByGoalGreaterThan(int nGoals) {
        return playerRepo.findByGoalCountGreaterThan(nGoals);
    }

    @Override
    public List<Player> findPlayersByJerseyNumber(int jerseyN) {
        return playerRepo.findByJerseyNumber(jerseyN);
    }

    @Override
    public List<Player> findPlayersByDobAfter(String dob) {
        return playerRepo.findByDobAfter(LocalDate.parse(dob));
    }

    @Override
    public List<Player> findPlayersBySurname(String surname) {
        return playerRepo.findBySurname(surname);
    }

    @Override
    public List<Player> findPlayersByPosition(String position) {
        return playerRepo.findByPosition(position);
    }

    @Override
    public List<Team> findAllTeams() {
        return teamRepo.findAll();
    }

}
