package it.accenture.serieA.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Match implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", referencedColumnName = "ID")
    private Team teamHome;
    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", referencedColumnName = "ID")
    private Team teamAway;
    @Column(name = "MATCH_DATE")
    private LocalDate matchDate;
    @ManyToOne
    @JoinColumn(name = "CHAMPIONSHIP_ID", referencedColumnName = "ID")
    private Championship championship;
    @OneToMany(mappedBy = "match")
    private List<Goal> goal;

}
