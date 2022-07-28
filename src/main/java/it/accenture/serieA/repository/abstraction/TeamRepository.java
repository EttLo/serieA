package it.accenture.serieA.repository.abstraction;

import it.accenture.serieA.model.Team;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    public Optional<Team> findById(Long id);

}
