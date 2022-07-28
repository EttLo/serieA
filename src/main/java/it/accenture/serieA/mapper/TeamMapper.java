package it.accenture.serieA.mapper;

import it.accenture.serieA.dto.PlayerDTO;
import it.accenture.serieA.dto.TeamDTO;
import it.accenture.serieA.model.Player;
import it.accenture.serieA.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TeamMapper {
    TeamMapper INSTANCE = Mappers.getMapper(TeamMapper.class);

    @Mapping(target = "coachSurname", source = "coach.surname")
    TeamDTO toTeamDTO(Team t);
    @Mapping(target = "coach.surname", source = "coachSurname")
    Team fromTeamDTO(TeamDTO tDTO);

    List<TeamDTO> toTeamsDTO(List<Team> listT);
}
