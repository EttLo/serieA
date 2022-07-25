package it.accenture.serieA.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import it.accenture.serieA.dto.PlayerDTO;
import it.accenture.serieA.model.Player;

@Mapper
public interface PlayerMapper {
    PlayerMapper INSTANCE = Mappers.getMapper(PlayerMapper.class);

    @Mapping(target = "teamId", source = "team.id")
    @Mapping(target = "teamName", source = "team.name")
    PlayerDTO toPlayerDTO(Player p);

    @Mapping(target = "team.id", source = "teamId")
    @Mapping(target = "team.name", source = "teamName")
    Player fromPlayerDTO(PlayerDTO pDTO);

    List<PlayerDTO> toPlayersDTO(List<Player> listP);
}
