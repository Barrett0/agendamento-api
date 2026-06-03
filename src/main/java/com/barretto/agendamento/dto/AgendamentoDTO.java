package com.barretto.agendamento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AgendamentoDTO(
        @NotBlank(message = "O serviço é obrigatório")
        String servico,

        @NotNull(message = "A data é obrigatória")
        @FutureOrPresent(message = "A data do agendamento deve ser hoje ou no futuro")
        LocalDate data,

        @NotNull(message = "O horário é obrigatório")
        LocalTime horario,

        @NotNull(message = "O ID do usuário é obrigatório")
        Long usuarioId
) {
}

