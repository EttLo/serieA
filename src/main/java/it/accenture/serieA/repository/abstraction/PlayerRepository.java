package it.accenture.serieA.repository.abstraction;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.accenture.serieA.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    public List<Player> findByTeamName(String teamName);

    @Query("SELECT p FROM Player p WHERE SIZE(p.goal)>=:nGoals")
    public List<Player> findByGoalCountGreaterThan(@Param("nGoals") int nGoals);
}
