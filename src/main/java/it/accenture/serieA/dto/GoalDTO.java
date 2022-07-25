package it.accenture.serieA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoalDTO {
    private Long id;
    private Long teamId;
    private String teamName;
    private Long opposingTeamId;
    private String opposingTeamName;
    private Long playerId;
    private String playerName;
    private String playerSurname;
    private int minute;
}
