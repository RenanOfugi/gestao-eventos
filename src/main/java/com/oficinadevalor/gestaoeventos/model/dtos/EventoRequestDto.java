package com.oficinadevalor.gestaoeventos.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record EventoRequestDto(

        @NotNull(message = "campo 'nome' do evento obrigatório")
        String nome,
        @NotNull(message = "campo 'descricao' do evento obrigatório")
        String descricao,
        @NotNull(message = "campo 'empresa' do evento obrigatório")
        String empresa,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @NotNull(message = "campo 'dataCriacao' do evento obrigatório")
        LocalDate dataCriacao
) {
}
