package com.oficinadevalor.gestaoeventos.model.dtos;

import com.oficinadevalor.gestaoeventos.enums.TipoCampoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record CampoEspecificoCreateRequestDto(

        @NotNull(message = "Campo titulo obrigatório do formulário específico")
        String titulo,

        @NotNull(message = "Campo valor obrigatório do formulário específico")
        String valor,

        @NotNull(message = "Campo tipo obrigatório do formulário específico")
        @Enumerated(EnumType.STRING)
        TipoCampoEnum tipo
) {
}
