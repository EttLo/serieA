package it.accenture.serieA.service.implementation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import it.accenture.serieA.model.Team;
import it.accenture.serieA.repository.abstraction.TeamRepository;
import org.springframework.stereotype.Service;

import it.accenture.serieA.model.Match;
import it.accenture.serieA.model.Player;
import it.accenture.serieA.repository.abstraction.MatchRepository;
import it.accenture.serieA.repository.abstraction.PlayerRepository;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;

@Service
public class ChampionshipService implements AbstractChampionshipService {
    private PlayerRepository playerRepo;
    private TeamRepository teamRepo;
    private MatchRepository matchRepo;

    public ChampionshipService(PlayerRepository pr, TeamRepository tr, MatchRepository mr) {
        this.playerRepo = pr;
        this.teamRepo = tr;
        this.matchRepo = mr;
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) {
        return playerRepo.findByTeamName(teamName.toUpperCase());
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
        return playerRepo.findBySurname(surname.toUpperCase());
    }

    @Override
    public List<Player> findPlayersByPosition(String position) {
        return playerRepo.findByPosition(position.toUpperCase());
    }

    @Override
    public List<Team> findAllTeams() {
        return teamRepo.findAll();
    }

    @Override
    public Optional<Team> findTeamById(Long id) {
        return teamRepo.findById(id);
    }

    @Override
    public List<Match> findMatchByMatchDate(String matchDate) {
        var start = LocalDate.parse(matchDate);
        return matchRepo.findByMatchDateBetween(start, start.plusDays(1));
    }

    @Override
    public List<Match> findMatchByTeamHomeName(String teamName) {
        return matchRepo.findByTeamHomeName(teamName.toUpperCase());
    }

    @Override
    public List<Match> findMatchByTeamAwayName(String teamName) {
        return matchRepo.findByTeamAwayName(teamName.toUpperCase());
    }

    @Override
    public List<Match> findMatchByTeamHomeNameOrTeamAwayName(String teamName, String tName) {
        return matchRepo.findByTeamHomeNameOrTeamAwayName(teamName.toUpperCase(), tName.toUpperCase());
    }

    @Override
    public List<Match> findMatchByChampionshipStartYear(int year) {
        return matchRepo.findByChampionshipStartYear(year);
    }

    @Override
    public List<Match> findMatchByGoalCountGreaterThan(int nGoals) {
        return matchRepo.findByGoalCountGreaterThan(nGoals);
    }

}
