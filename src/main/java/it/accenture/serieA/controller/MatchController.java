package it.accenture.serieA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.serieA.mapper.MatchMapper;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;

@CrossOrigin
@RestController
@RequestMapping("api/match")
public class MatchController {
    private AbstractChampionshipService championshipService;

    @Autowired
    public MatchController(AbstractChampionshipService cs) {
        this.championshipService = cs;
    }

    @GetMapping
    public ResponseEntity<?> find(
            @RequestParam(required = false) String matchDate,
            @RequestParam(required = false) String teamName,
            @RequestParam(required = false) String homeTeamName,
            @RequestParam(required = false) String awayTeamName,
            @RequestParam(required = false) Integer goals,
            @RequestParam(required = false) Integer year) {

        if (matchDate != null && !matchDate.isBlank()) {
            var games = championshipService.findMatchByMatchDate(matchDate);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        if (teamName != null && !teamName.isBlank()) {
            var games = championshipService.findMatchByTeamHomeNameOrTeamAwayName(teamName, teamName);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        if (homeTeamName != null && !homeTeamName.isBlank()) {
            var games = championshipService.findMatchByTeamHomeName(homeTeamName);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        if (awayTeamName != null && !awayTeamName.isBlank()) {
            var games = championshipService.findMatchByTeamAwayName(awayTeamName);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        if (goals != null && goals > 0) {
            var games = championshipService.findMatchByGoalCountGreaterThan(goals);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        if (year != null && year > 0) {
            var games = championshipService.findMatchByChampionshipStartYear(year);
            return ResponseEntity.ok(MatchMapper.INSTANCE.toMatchesDTO(games));
        }
        return ResponseEntity.badRequest().body("la ricerca deve comprendere almeno un parametro");
    }

}
