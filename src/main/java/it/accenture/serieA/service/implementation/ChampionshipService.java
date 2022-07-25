package it.accenture.serieA.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import it.accenture.serieA.model.Player;
import it.accenture.serieA.repository.abstraction.PlayerRepository;
import it.accenture.serieA.service.abstraction.AbstractChampionshipService;

@Service
public class ChampionshipService implements AbstractChampionshipService {
    private PlayerRepository playerRepo;

    public ChampionshipService(PlayerRepository pr) {
        this.playerRepo = pr;
    }

    @Override
    public List<Player> findPlayersByTeamName(String teamName) {
        return playerRepo.findByTeamName(teamName);
    }

}
