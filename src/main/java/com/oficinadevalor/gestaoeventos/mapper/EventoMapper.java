package com.oficinadevalor.gestaoeventos.mapper;

import com.oficinadevalor.gestaoeventos.model.Evento;
import com.oficinadevalor.gestaoeventos.model.dtos.EventoRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventoMapper {

    EventoMapper INSTANCE = Mappers.getMapper(EventoMapper.class);

    Evento requestDtoToEntity(EventoRequestDto requestDto);
}
