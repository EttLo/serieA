package it.accenture.serieA.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import it.accenture.serieA.dto.ChampionshipDTO;
import it.accenture.serieA.model.Championship;

@Mapper
public interface ChampionshipMapper {
    ChampionshipMapper INSTANCE = Mappers.getMapper(ChampionshipMapper.class);

    ChampionshipDTO toChampionshipDTO(Championship c);

    Championship fromChampionshipDTO(ChampionshipDTO cDTO);

}
