package it.accenture.serieA.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.accenture.serieA.dto.GoalDTO;
import it.accenture.serieA.model.Goal;

@Mapper
public interface GoalMapper {
    GoalMapper INSTANCE = Mappers.getMapper(GoalMapper.class);

    @Mapping(target = "teamId", source = "player.team.id")
    @Mapping(target = "teamName", source = "player.team.name")
    @Mapping(target = "playerId", source = "player.id")
    @Mapping(target = "playerName", source = "player.name")
    @Mapping(target = "playerSurname", source = "player.surname")
    GoalDTO toGoalDTO(Goal g);

    @Mapping(source = "teamId", target = "player.team.id")
    @Mapping(source = "teamName", target = "player.team.name")
    @Mapping(source = "playerId", target = "player.id")
    @Mapping(source = "playerName", target = "player.name")
    @Mapping(source = "playerSurname", target = "player.surname")
    Goal fromGoalDTO(GoalDTO gDTO);

    List<GoalDTO> toGoalsDTO(List<Goal> listG);

}
