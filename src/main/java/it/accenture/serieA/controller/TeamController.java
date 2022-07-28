package it.accenture.serieA.controller;

import it.accenture.serieA.mapper.TeamMapper;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("api/team")
public class TeamController {
    private AbstractChampionshipService championshipService;
    @Autowired
    public TeamController(AbstractChampionshipService cs) {
        this.championshipService = cs;
    }
    @GetMapping
    public ResponseEntity<?> find() {
        var teams = championshipService.findAllTeams();
        return ResponseEntity.ok(TeamMapper.INSTANCE.toTeamsDTO(teams));
    }
}
