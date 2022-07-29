package it.accenture.serieA.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.accenture.serieA.dto.MatchDTO;
import it.accenture.serieA.model.Match;

@Mapper(uses = { GoalMapper.class })
public interface MatchMapper {
    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    @Mapping(target = "homeTeamId", source = "teamHome.id")
    @Mapping(target = "homeTeamName", source = "teamHome.name")
    @Mapping(target = "awayTeamId", source = "teamAway.id")
    @Mapping(target = "awayTeamName", source = "teamAway.name")
    @Mapping(target = "championshipId", source = "championship.id")
    @Mapping(target = "championshipYear", source = "championship.startYear")
    MatchDTO toMatchDTO(Match m);

    @Mapping(target = "teamHome.id", source = "homeTeamId")
    @Mapping(target = "teamHome.name", source = "homeTeamName")
    @Mapping(target = "teamAway.id", source = "awayTeamId")
    @Mapping(target = "teamAway.name", source = "awayTeamName")
    @Mapping(target = "championship.id", source = "championshipId")
    @Mapping(target = "championship.startYear", source = "championshipYear")
    Match fromMatchDTO(MatchDTO mDTO);

    List<MatchDTO> toMatchesDTO(List<Match> listM);

}
