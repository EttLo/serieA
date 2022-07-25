package it.accenture.serieA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {
    private Long id;
    private String teamName;
    private int points;
    private Long championshipId;
    private int championshipYear;
}
