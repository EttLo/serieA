package it.accenture.serieA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoachDTO {
    private Long id;
    private String name;
    private String surname;
    private String palmares;
}
