package com.oficinadevalor.gestaoeventos.mapper;

import com.oficinadevalor.gestaoeventos.model.CampoEspecifico;
import com.oficinadevalor.gestaoeventos.model.FormularioComum;
import com.oficinadevalor.gestaoeventos.model.dtos.CampoEspecificoCreateRequestDto;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumCreateRequestDto;
import com.oficinadevalor.gestaoeventos.model.dtos.FormularioComumUpdateRequestDto;
import com.oficinadevalor.gestaoeventos.model.dtos.CampoEspecificoUpdateRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FormularioComumMapper {

    FormularioComumMapper INSTANCE = Mappers.getMapper(FormularioComumMapper.class);

    FormularioComum dtoCreateToEntity(FormularioComumCreateRequestDto requestDto);

    //List<FormularioEspecifico> listEspecificoDtoToListEntity(List<FormularioEspecificoCreateRequestDto> listDto);

    @Mapping(source = "tipo", target = "tipoCampo.tipo")
    CampoEspecifico especificoDtoToEntity(CampoEspecificoCreateRequestDto dto);

    FormularioComum dtoCreateToEntity(FormularioComumUpdateRequestDto requestDto);

    List<CampoEspecifico> listEspecificoDtoToListEntity(List<CampoEspecificoUpdateRequestDto> listDto);

    @Mapping(source = "tipo", target = "tipoCampo.tipo")
    CampoEspecifico especificoDtoToEntity(CampoEspecificoUpdateRequestDto dto);
}
