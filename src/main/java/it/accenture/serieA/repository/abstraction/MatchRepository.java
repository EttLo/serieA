package it.accenture.serieA.repository.abstraction;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.accenture.serieA.model.Match;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findByMatchDateBetween(LocalDate start, LocalDate end);

    List<Match> findByTeamHomeName(String teamName);

    List<Match> findByTeamAwayName(String teamName);

    List<Match> findByTeamHomeNameOrTeamAwayName(String teamName, String tName);

    List<Match> findByChampionshipStartYear(int year);

    @Query("SELECT m FROM Match m WHERE SIZE(m.goals)>=:nGoals")
    List<Match> findByGoalCountGreaterThan(@Param("nGoals") int nGoals);
}
