package it.accenture.serieA.controller;

import it.accenture.serieA.mapper.TeamMapper;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<?> find(@RequestParam(required = false) Long id) {

        var teams = championshipService.findAllTeams();
        return ResponseEntity.ok(TeamMapper.INSTANCE.toTeamsDTO(teams));
    }

    @GetMapping(value = "{teamId}")
    public ResponseEntity<?> findById(@PathVariable Long teamId) {
        if (teamId > 0) {
            var team = championshipService.findTeamById(teamId);
            return team.isPresent() ? ResponseEntity.ok(TeamMapper.INSTANCE.toTeamDTO(team.get()))
                    : ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.badRequest().body("l' id deve essere positivo");
        }
    }

}
