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
public class Player implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DOB")
    private LocalDate dob;
    @Column(name = "JERSEY_NUMBER")
    private int jerseyNumber;
    @Column(name = "POSITION")
    private String position;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", referencedColumnName = "ID")
    private Team team;
    @OneToMany(mappedBy = "player")
    private List<Goal> goals;
}
