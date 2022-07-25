package it.accenture.serieA.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChampionshipDTO {
    private Long id;
    private String startDate;
    private String endDate;
    private int startYear;
    private List<RankingDTO> rankings;
}
