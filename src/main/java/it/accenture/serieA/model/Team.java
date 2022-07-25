package it.accenture.serieA.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Team implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CITY")
    private String city;
    @OneToOne
    @JoinColumn(name = "COACH_ID", referencedColumnName = "ID")
    private Coach coach;
    @OneToMany(mappedBy = "team")
    private List<Ranking> ranking;
    @OneToMany(mappedBy = "team")
    private List<Player> player;
    @OneToMany(mappedBy = "teamHome")
    private List<Match> match_home;
    @OneToMany(mappedBy = "teamAway")
    private List<Match> match_away;

}
