package it.accenture.serieA;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import it.accenture.serieA.dto.GoalDTO;
import it.accenture.serieA.dto.MatchDTO;
import it.accenture.serieA.mapper.GoalMapper;
import it.accenture.serieA.mapper.MatchMapper;
import it.accenture.serieA.model.Championship;
import it.accenture.serieA.model.Goal;
import it.accenture.serieA.model.Match;
import it.accenture.serieA.model.Player;

public class MatchMapperTest {
    @Test
    public void match_mapper_should_map_goals() {
        List<Goal> goals = new ArrayList<>();
        Championship c = new Championship();
        Player p = new Player();
        p.setId(1L);
        Match m = new Match(50L, null, null, null, c, goals);
        goals.add(new Goal(24L, m, p, 75));
        goals.add(new Goal(25L, m, p, 75));
        m.setGoals(goals);
        MatchDTO mDTO = MatchMapper.INSTANCE.toMatchDTO(m);
        assertEquals(goals.get(0).getPlayer().getId(), mDTO.getGoals().get(0).getPlayerId());
    }

    @Test
    public void goal_mapper_should_map_player() {
        Player p = new Player();
        p.setId(1L);
        Goal g = new Goal(24L, null, p, 75);
        GoalDTO gDTO = GoalMapper.INSTANCE.toGoalDTO(g);
        assertEquals(g.getPlayer().getId(), gDTO.getPlayerId());

    }
}
