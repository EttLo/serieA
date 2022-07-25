package it.accenture.serieA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    private String name;
    private String surname;
    private String dob;
    private int jerseyNumber;
    private String position;
    private Long teamId;
    private String teamName;
}
