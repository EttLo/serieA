package it.accenture.serieA.repository.abstraction;

import it.accenture.serieA.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository  extends JpaRepository<Team, Long> {

}
