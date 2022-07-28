package it.accenture.serieA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.accenture.serieA.mapper.PlayerMapper;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;

@CrossOrigin
@RestController
@RequestMapping("api/player")
public class PlayerController {
    private AbstractChampionshipService championshipService;

    @Autowired
    public PlayerController(AbstractChampionshipService cs) {
        this.championshipService = cs;
    }

    @GetMapping
    public ResponseEntity<?> find(
            @RequestParam(required = false) String teamName,
            @RequestParam(required = false) Integer nGoals,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Integer jerseyN) {
        if (teamName != null && !teamName.isBlank()) {
            var players = championshipService.findPlayersByTeamName(teamName);
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        if (nGoals != null && nGoals > 0) {
            var players = championshipService.findPlayersByGoalGreaterThan(nGoals);
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        if (surname != null && !surname.isBlank()) {
            var players = championshipService.findPlayersBySurname(surname);
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        if (position != null && !position.isBlank()) {
            var players = championshipService.findPlayersByPosition(position);
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        if (year != null && year > 0) {
            var players = championshipService.findPlayersByDobAfter(year + "-01-01");
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        if (jerseyN != null && jerseyN > 0) {
            var players = championshipService.findPlayersByJerseyNumber(jerseyN);
            return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
        }
        return ResponseEntity.badRequest().body("la ricerca deve comprendere almeno un parametro");
    }

}
