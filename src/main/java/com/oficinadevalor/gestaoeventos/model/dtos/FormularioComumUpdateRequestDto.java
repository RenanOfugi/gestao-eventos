package com.oficinadevalor.gestaoeventos.model.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record FormularioComumUpdateRequestDto(
        @NotNull(message = "Campo nome obrigatório do formulário comum")
        String nome,

        @Email(message = "Email inválido", regexp = "^(?=.{1,64}@)[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
        @NotNull(message = "Campo email obrigatório do formulário comum")
        String email,

        @NotNull(message = "Campo endereço obrigatório do formulário comum")
        String endereco,

        @NotNull(message = "Campo valor obrigatório do formulário comum")
        BigDecimal valor,

        @NotNull(message = "Campo idEvento obrigatório do formulário comum")
        Long idEvento,

        @NotNull(message = "Campo camposEspecificos obrigatório do formulário comum")
        List<CampoEspecificoUpdateRequestDto> camposEspecificos
) {
}
