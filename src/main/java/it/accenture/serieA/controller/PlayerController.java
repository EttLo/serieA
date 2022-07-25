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
    public ResponseEntity<?> find(@RequestParam(required = false) String teamName) {
        if (teamName == null || teamName.isBlank()) {
            return ResponseEntity.badRequest().body("la ricerca deve comprendere almeno un parametro");
        }
        var players = championshipService.findPlayersByTeamName(teamName);
        return ResponseEntity.ok(PlayerMapper.INSTANCE.toPlayersDTO(players));
    }

}
