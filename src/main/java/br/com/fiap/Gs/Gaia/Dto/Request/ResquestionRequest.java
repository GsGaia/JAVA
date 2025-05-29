package br.com.fiap.Gs.Gaia.Dto.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ResquestionRequest {
    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private String unit;

    @NotEmpty
    private LocalDate dataDaRequisicao;
}
