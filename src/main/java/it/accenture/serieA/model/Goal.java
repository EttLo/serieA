package it.accenture.serieA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Goal implements WithId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MATCH_ID", referencedColumnName = "ID")
    private Match match;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PLAYER_ID", referencedColumnName = "ID")
    private Player player;
    @Column(name = "MINUTE")
    private int minute;
}
